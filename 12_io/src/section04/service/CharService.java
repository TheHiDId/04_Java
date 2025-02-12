package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* [문자 기반 스트림]
 * 2byte 문자(char) 단위로 입출력하는 스트림
 * 문자만 작성된 파일(txt, bin 등), 채팅, JSON, 웹 요청/응답(HTML) 등
 * 문자 기반 스트림 최상위 인터페이스: Reader(입력), Writer(출력)
 */
public class CharService {
	String content = 
""" 
Do you remember the 21st night of September?
9월의 21번째 밤을 기억하나요?
Love was changin' the mind of pretenders
사랑이 위선자들의 마음을 바꾸고
While chasin' the clouds away
구름도 거둬들이고 있던 그 날

Our hearts were ringin'
우리 가슴은 뛰고 있었죠
In the key that our souls were singin'
우리의 영혼이 부르던 노래에 맞춰
As we danced in the night, remember
우리가 밤에 춤을 출 때
How the stars stole the night away,
별들이 어둠을 거두어 가던 걸 기억하나요?

oh, yeah yeah yeah
Hey, hey, hey!
Ba-dee ya,
say, do you remember?
기억하시나요?
Ba-dee ya,
dancin' in September
9월의 춤을
Ba-dee ya,
never was a cloudy day
구름 한 점 없는 날이었죠

Ba duda, ba duda,
ba duda, badu
Ba duda, badu, ba duda, badu
Ba duda, badu, ba duda

My thoughts are with you
난 당신과 같은 생각을 해요
Holdin' hands with your heart to see you
마음으로 손을 잡고 당신을 봐요
Only blue talk and love, remember
우울한 대화와 사랑, 기억해요
How we knew love was here to stay
우리 곁에 이 사랑이 남아 있다는 사실을

Now, December found the love
지금은 12월이고, 우리는
that we shared in September
9월부터 나눠 온 사랑을 찾았죠.
Only blue talk and love, remember
우울한 대화와 사랑, 기억해요
The true love we share today
오늘 우리가 나눈 진정한 사랑을

Hey, hey, hey!
Ba-dee ya,
say, do you remember?
기억하시나요?
Ba-dee Ya,
dancin' in September
9월의 춤을
Ba-dee ya,
never was a cloudy day
구름 한 점 없는 날이었죠

There was a...
Ba-dee ya, (dee ya dee ya)
say, do you remember?
기억하시나요?
Ba-dee ya, (dee ya dee ya)
dancin' in September
9월의 춤을
Ba-dee ya, (dee ya dee ya)
golden dreams were shiny days
금빛 꿈으로 빛나는 날이었죠

The bell was ringin', oh oh
벨 소리가 울리고
Our souls were singin'
우리의 영혼은 노래하고
Do you remember
기억하시나요?
never a cloudy day, Yow
구름 한 점 없는 날이었죠

There was a...
Ba-dee ya, (dee ya dee ya)
say, do you remember?
기억하시나요?
Ba-dee ya, (dee ya dee ya)
dancin' in September
9월의 춤을
Ba-dee ya, (dee ya dee ya)
never was a cloudy day
구름 한 점 없는 날이었죠

And we'll say...
Ba-dee ya, (dee ya dee ya)
say, do you remember?
기억하시나요?
Ba-dee ya, (dee ya dee ya)
dancin' in September
9월의 춤을
Ba-dee ya, (dee ya dee ya)
golden dreams were shiny days
금빛 꿈으로 빛나는 날이었죠

Ba-dee ya, dee ya dee ya
Ba-dee ya, dee ya dee ya
Ba-dee ya, dee ya dee ya, dee ya!
Ba-dee ya, dee ya dee ya
Ba-dee ya, dee ya dee ya
Ba-dee ya, dee ya dee ya, dee ya!
""";
	
	/**
	 * 문자 기반 출력 스트림 이용해서 파일 출력
	 */
	public void fileOutput1() {
		FileWriter fw = null;
		
		try {
			// 폴더가 없을 경우 생성
			String path = "io_test\\char";
			
			File folder = new File(path);
			
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "\\" + "September.txt");
			
			// 문자 기반 스트림을 이용해서 출력
			fw.write(content);
			
			fw.flush(); // 스트림에 남은 데이터를 밀어냄 -> close() 시 자동 실행됨
			
			System.out.println("출력 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(fw != null ) fw.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOutput2() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			// 폴더가 없을 경우 생성
			String path = "io_test\\char";
			
			File folder = new File(path);
			
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "\\" + "September_Buffered.txt");
			
			// 보조 스트림 객체 생성
			bw = new BufferedWriter(fw);
			
			// 문자 기반 보조 스트림을 이용해서 출력
			bw.write(content);
			
			bw.flush(); // 스트림에 남은 데이터를 밀어냄 -> close() 시 자동 실행됨
			
			System.out.println("출력 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(bw != null ) bw.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 문자 기반 입력 스트림 + 보조 스트림 이용해서 입력 
	 */
	public void fileInput() {
		/* try - with - resource
		 * finally에서 작성하던 close() 처리 구문을 자동으로 수행하도록 만든 구문
		 */
		String path = "io_test\\char\\September.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			// 보조 스트림 이용해서 파일 내용 읽어오기
			StringBuilder sb = new StringBuilder(); // 읽어온 내용 누적할 변수
			
			String temp = null; // 임시 변수
			
			while(true) {
				temp = br.readLine(); // 한 줄씩 읽어오기
				
				if(temp == null) break; // 읽어온 내용이 없으면 반복 종료
				
				sb.append(temp); // 읽어온 내용 누적
				sb.append("\n"); // 줄바꿈
			}
			
			System.out.println("읽어오기 성공!");
			
			System.out.println();
			
			System.out.println(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} // finally에서 close하던 구문 생략 가능
	}
	
	// Scanner 대신 스트림을 이용한 문자 입력 -> Scanner 편리하지만 매우 느림
	// 키보드 입력 -> 바이트 코드(2진수) 입력 -> 문자로 변환
	
	public void keyboardInput() {
		// System.in: 기본 장치(키보드)와 연결된 InputStream 반환 (바이트 스트림)
		// InputStreamReader: 바이트 스트림을 문자 스트림으로 변환
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			System.out.print("문자열 입력1: ");
			String input1 = br.readLine();
			
			System.out.print("문자열 입력2: ");
			String input2 = br.readLine();
			
			System.out.print("문자열 입력3: ");
			String input3 = br.readLine();
			
			System.out.println("input1: " + input1);
			System.out.println("input2: " + input2);
			System.out.println("input3: " + input3);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(isr != null) isr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
