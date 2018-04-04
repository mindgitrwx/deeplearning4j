package org.deeplearning4j.text.tokenization.tokenizer;

import org.deeplearning4j.text.tokenization.tokenizerfactory.KoreanTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kepricon on 16. 10. 24.
 */
public class KoreanTokenizerTest {
    @Test
    public void testKoreanTokenizer() throws Exception {
        String toTokenize = "세계 최초의 상용 수준 오픈소스 딥러닝 라이브러리입니다";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"세계", "최초", "의", "상용", "수준", "오픈소스", "딥", "러닝", "라이브러리", "입니", "다"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }

    /**
     *
     * @added by jongHyeon yeo on 18. 04. 04
     * please mail to me any grammar error on this codes.
     * jonghyeon.rw@gmail.com
     * Todo: find exact source of Korean language grammar like '국립국어원'
     */
    @Test
    public void testKoreanTokenPostPosition() throws Exception {
        String toTokenize = "너한테서 받은 돈을 선생님께서 나 한테로 보냈다는데";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"너", "한테서", "받", "은", "돈", "을", "선생님", "께서", "나", "한테로", "보냈", "다", "는데"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }

    // Success - 시, 가, 강, 가, 고려, 가요, 장, 가, 보, 은, 개구, 쟁이 - Expected error
    @Test
    public void testKoreanTokenNouns() throws Exception {
        String toTokenize = "시가 강가 고려가요 장가 보은 개구쟁이";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"시가", "강가", "고려가요", "장가", "보은", "개구쟁이"};

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            System.out.print(tokenizer.nextToken());
            System.out.print(" ");
        }

        assertEquals(expect.length, tokenizer.countTokens());
        assertEquals(6, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }

    // '관형사' test
    @Test
    public void testKoreanTokenDeterminer() throws Exception {
        String toTokenize = "별의별 일이 다 있다";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"별의별", "일", "이",  "다",  "있", "다"};

        assertEquals(expect.length, tokenizer.countTokens());
        assertEquals(6, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }

    @Test
    public void testKoreanTokenOne() throws Exception {
        String toTokenize = "일";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"일"};

        assertEquals(expect.length, tokenizer.countTokens());
        assertEquals(1, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }

    @Test
    public void testKoreanTokenZero() throws Exception {
        String toTokenize = " ";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {" "};

        assertEquals(expect.length, tokenizer.countTokens());
        assertEquals(0, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }

    @Test
    public void testKoreanTokenNumber() throws Exception {
        String toTokenize = "일이삼사오육칠팔구";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"일", "이", "삼", "사",
                           "오", "육", "칠", "팔", "구"};

        assertEquals(expect.length, tokenizer.countTokens());
        assertEquals(8, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
            if(i == 0)
            {assertEquals("일", expect[i]);}
            if(i == 1)
            {assertEquals("이", expect[i]);}
            if(i == 2)
            {assertEquals("삼", expect[i]);}
            if(i == 3)
            {assertEquals("사", expect[i]);}
            if(i == 4)
            {assertEquals("오", expect[i]);}
            if(i == 5)
            {assertEquals("육", expect[i]);}
            if(i == 6)
            {assertEquals("칠", expect[i]);}
            if(i == 7)
            {assertEquals("팔", expect[i]);}
            if(i == 8)
            {assertEquals("구", expect[i]);}
        }
    }

    // Boundary Long words test.
    @Test
    public void testKoreanTokenNoun() throws Exception {
        String toTokenize = "얼룩보금자리산세비에리아 고운점박이푸른부전나비 모시금자라남생이잎벌레 송곳벌레살이납작맵시벌 어리등에살이뭉툭맵시벌 " +
                            "조선민주주의인민공화국 닥다르그르딱다그르르하다";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"얼룩보금자리산세비에리아", "고운점박이푸른부전나비",
                           "모시금자라남생이잎벌레", "송곳벌레살이납작맵시벌",
                           "어리등에살이뭉툭맵시벌", "조선민주주의인민공화국",
                           "딱다르그르딱다그르르", "하다"};

        assertEquals(expect.length, tokenizer.countTokens());
        assertEquals(8, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
}
