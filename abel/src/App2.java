public class App2 {
	public static int lengthofLastword(String s){
		//consisting of non-space characters only, I used trim as we learn in Zoom class 
            s = s.trim();
			//length=len
            int len = 0;
			int lastIndex = s.length() - 1;
			while (lastIndex >= 0 && s.charAt(lastIndex) != ' '){
				len++;
				lastIndex--;
			}
           return len;

	}
	public static void main(String[] args)
	{
		String input = "Hellow Codivers Technologies";
		int lastWordLength = lengthofLastword(input);
		System.out.println("Length of the last word: " +lastWordLength);

	}
}
