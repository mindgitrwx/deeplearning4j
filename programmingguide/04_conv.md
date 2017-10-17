---
title: DeepLearning4j Convolutional Network
layout: default
---

------

# DeepLearning4j: Convolutional Network Example

In this chapter, we will show an example for a convolutional network. This example will be based on the [AnimalClassification.java](https://github.com/deeplearning4j/dl4j-examples/blob/master/dl4j-examples/src/main/java/org/deeplearning4j/examples/convolution/AnimalsClassification.java) program and t the data which available [here](https://github.com/deeplearning4j/dl4j-examples/tree/master/dl4j-examples/src/main/resources/animals).

- [**Data and ETL**](#ETL) 
- [**Building a Convolutional Network**](#Building) 
- [**Training and Evaluating**](#Training)  

## <a name="ETL">Data and ETL</a>

The data consists of jpeg images of four different types of animals: bears, deer, ducks, and turtles. There are 22 bears, 20 deer, 22 ducks, and 20 turtles total. The first process in building a neural network is to prepare the data. Thus, there are 4 possible labels.

```
protected static int numLabels = 4;
```

Since each image is located in the directory of its animal type (i.e. images of bears are contained in a directory called bear, images of deer are continaed in a directory called deer, and etc.), the ParentPathLabelGenerator is used. This essentially creates labels from the directories each of the images are contained in. labelMaker will be used later on.

```
ParentPathLabelGenerator labelMaker = new ParentPathLabelGenerator();
```

We then obtain the main path of the directory that contains the files and split the files according to a random seed rng. The BalancedPathFilter is used to randomize the paths and removes paths randomly so that there is the same number of paths for each label. After this step we will end up with 80 examples or images with 20 images in each animal class.

```
protected static int batchSize = 20;
protected static int numExamples = 80;
protected static Random rng = new Random(seed);

File mainPath = new File(System.getProperty("user.dir"), "dl4j-examples/src/main/resources/animals/");
FileSplit fileSplit = new FileSplit(mainPath, NativeImageLoader.ALLOWED_FORMATS, rng);
BalancedPathFilter pathFilter = new BalancedPathFilter(rng, labelMaker, numExamples, numLabels, batchSize);
```

The next step splits the data into train and test sets. The train split contains 80 percent of the data and the test set is comprised of 20 percent of the data. We will later train the neural network on the training set and evaluate the model on the test set.

```
protected static double splitTrainTest = 0.8;

InputSplit[] inputSplit = fileSplit.sample(pathFilter, splitTrainTest, 1 - splitTrainTest);
InputSplit trainData = inputSplit[0];
InputSplit testData = inputSplit[1];
```

Because the dataset is small, we can augment generate a larger dataset from the 80 examples. This is done by transforming the given images with FlipImageTransform and WarpImageTransform. FlipImageTransform randomly flips the image according either the x-axis, y-axis, or both, and WarpImageTransform warps the image deterministically or randomly. Thus, transformed images will still share the label of the original images.

```
ImageTransform flipTransform1 = new FlipImageTransform(rng);
ImageTransform flipTransform2 = new FlipImageTransform(new Random(123));
ImageTransform warpTransform = new WarpImageTransform(rng, 42);
List<ImageTransform> transforms = Arrays.asList(new ImageTransform[]{flipTransform1, warpTransform, flipTransform2});
```

The images still need to be converted in a format that neural networks can read.  Standard RecordReaders and DataSetIterators are used for this purpose. The ImageRecordReader takes in the height, width, and number of channels of the images and the labelMaker as parameters.
   
```   
protected static int height = 100;
protected static int width = 100;
protected static int channels = 3;

ImageRecordReader recordReader = new ImageRecordReader(height, width, channels, labelMaker);
DataSetIterator dataIter;
```

To initialize the RecordReader and the DataSetIterator to the data, the following lines of code are needed. 

```
recordReader.initialize(trainData);
dataIter = new RecordReaderDataSetIterator(recordReader, batchSize, 1, numLabels);
```

Addtionally, if we want to scale our images, we can use an ImagePreProcessingScaler and fit it to our DataSetIterator.

```
DataNormalization scaler = new ImagePreProcessingScaler(0, 1);
scaler.fit(dataIter);
dataIter.setPreProcessor(scaler);
```

Lastly, if we want DL4J to automatically train the data with multiple epochs and not explicitly do this via loops, we can define a MultipleEpochsIterator which takes in the number of epochs and the DataSetIterator.

```
protected static int epochs = 50;
MultipleEpochsIterator trainIter = new MultipleEpochsIterator(epochs, dataIter);
```

The above process converts the original data without the transformed images. If the transformations are desired, then simply initialize the RecordReader with the transforms in a loop.

```
for (ImageTransform transform : transforms) {
    recordReader.initialize(trainData, transform);
    // above code with DataSetIterator and etc.
}
```
## <a name="Building">Building a Convolutional Neural Network</a>

Now that the data is ready, we can finally build the neural network. In this example, we will use MultiLayerNetwork to build a convolutional network. To start off, we need to set the network configuration using MultiLayerConfiguration. The code chunk needed is shown below.

```
MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
    .seed(seed)
    .iterations(iterations)
    .regularization(false).l2(0.005) 
    .activation(Activation.RELU)
    .learningRate(0.0001)
    .weightInit(WeightInit.XAVIER)
    .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
    .updater(new Nesterovs(0.9))
    .list()
    .layer(0, convInit("cnn1", channels, 50 ,  new int[]{5, 5}, new int[]{1, 1}, new int[]{0, 0}, 0))
    .layer(1, maxPool("maxpool1", new int[]{2,2}))
    .layer(2, conv5x5("cnn2", 100, new int[]{5, 5}, new int[]{1, 1}, 0))
    .layer(3, maxPool("maxool2", new int[]{2,2}))
    .layer(4, new DenseLayer.Builder().nOut(500).build())
    .layer(5, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
        .nOut(numLabels)
        .activation(Activation.SOFTMAX)
        .build())
    .backprop(true).pretrain(false)
    .setInputType(InputType.convolutional(height, width, channels))
    .build();
```

This code depends on a few defined funcions and variables below to help make the code more readable.

```
protected static int channels = 3;

private ConvolutionLayer convInit(String name, int in, int out, int[] kernel, int[] stride, int[] pad, double bias) {
    return new ConvolutionLayer.Builder(kernel, stride, pad).name(name).nIn(in).nOut(out).biasInit(bias).build();
}

private ConvolutionLayer conv5x5(String name, int out, int[] stride, int[] pad, double bias) {
    return new ConvolutionLayer.Builder(new int[]{5,5}, stride, pad).name(name).nOut(out).biasInit(bias).build();
}

private SubsamplingLayer maxPool(String name,  int[] kernel) {
    return new SubsamplingLayer.Builder(kernel, new int[]{2,2}).name(name).build();
}
```

Thus, we see that the first convolutional layer consists of a kernel of size 5 by 5, stride of 1 by 1, and 0 padding and takes in an input image with 3 channels. The second layer consists of a maxpool layer which has a kernel size of 2 by 2. Thus, the max value of each 2 by 2 block in the output from the convolutional layer will be used for input into the next layer, the second convolutional layer. This second convolutional layer takes has kernel size of 5 by 5, stride of 1 by 1, and pads the input using zeros in each dimension. Another maxpool layer is used, which outputs values into a 500 node dense layer. The final layer is the output layer which uses the negative log likelihood loss, 4 output labels (since there are 4 animal types), and a softmax activation for classification. 

## <a name="Training">Training and Evaluating a Convolutional Neural Network</a>

Once the configuration of the neural network is defined, we are ready to train the model. 

```
MultiLayerNetwork network = new MultiLayerNetwork(conf);
network.fit(trainIter);
```

Since trainIter is a MultiEpochsIterator, the network will automatically be trained using 50 epochs. Once the training is complete, it is easy to evaluate the model on the test data. We assume dataIter consists of the test data. The process is similar to converting the training data to a DataSetIterator.

```
Evaluation eval = network.evaluate(dataIter);
log.info(eval.stats(true));
```

This concludes our example of a convolutional neural network using DL4J. We will learn about creating other neural network types using DL4J in later chapters.