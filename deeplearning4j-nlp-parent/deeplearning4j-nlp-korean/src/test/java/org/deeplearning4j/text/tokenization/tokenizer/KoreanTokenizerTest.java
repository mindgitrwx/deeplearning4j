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
    
    @Test
    public void testKoreanTokenizer1() throws Exception {
        String toTokenize = "집에서 학교로 가고있다";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"집","에서","학교","로","가고","있다"i-};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
    @Test
    public void testKoreanTokenizer2() throws Exception {
        String toTokenize = "이 길은 이곳부터 시작해서 저 끝으로 뻗는다"
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"이","길","은","이곳","부터","시작","해서","저","끝","으로","뻗는다"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
    @Test
    public void testKoreanTokenizer3() throws Exception {
        String toTokenize = "야ㅋㅋㅋㅋㅋ";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"야","ㅋㅋㅋㅋ"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
    @Test
    public void testKoreanTokenizer4() throws Exception {
        String toTokenize = "너는 학생이니 본분을 지켜라";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"너","는","학생","이니","본분","을","지켜라"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
    @Test
    public void testKoreanTokenizer5() throws Exception {
        String toTokenize ="그는 돕기는커녕 방해할 생각만 하고 있는 듯했다";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"그","는","돕기","는커녕","방해","할","생각","만","하고","있는","듯했다"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
    @Test
    public void testKoreanTokenizer6() throws Exception {
        String toTokenize = "지방 미인 대회라야 그 규모가 크지 않다";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"지방","미인","대회","라야","그","규모","가","크지","않다"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
    @Test
    public void testKoreanTokenizer7() throws Exception {
        String toTokenize = "아마 여기에서부터 두 시간은 걸어야 할 거야.";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"아마","여기","에서부터","두","시간","은","걸어야","할","거야"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }
    @Test
    public void testKoreanTokenizer8() throws Exception {
        String toTokenize = 
              "밥이 없으면 라면이라도 주세요";
        TokenizerFactory t = new KoreanTokenizerFactory();
        Tokenizer tokenizer = t.create(toTokenize);
        String[] expect = {"밥","이","없으면","라면","이라도","주세요"};

        assertEquals(expect.length, tokenizer.countTokens());

        for (int i = 0; i < tokenizer.countTokens(); ++i) {
            assertEquals(tokenizer.nextToken(), expect[i]);
        }
    }

}
