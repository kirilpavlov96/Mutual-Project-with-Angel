
public class EncryptDecrypt {
	static final private char[][] encryptionArray={	{'0','0','0','0','0','0'},
													{'Z','B','M','S','J','C'},
													{'0','I','F','N','T','E'},
													{'0','R','L','A','H','K'},
													{'0','D','O','G','Q','V'},
													{'0','U','W','X','Y','P'}};
	static final private int[] positions={33,11,15,41,25,22,43,34,21,14,35,32,12,23,42,55,44,31,13,24,51,45,52,53,54,10};
	private String word;
	private boolean isEncrypted;
	
	public EncryptDecrypt(){
		this.word=null;
		this.isEncrypted=false;
	}
	public EncryptDecrypt(String word) {
		this.word=word;
		this.isEncrypted=false;
	}
	
	public void setWord(String word){
		this.word=word;
		this.isEncrypted=false;
	}
	
	public String getWord(){
		if(this.word==null) return "No word";
		else return this.word;
	}
	
	static private String changeLetters(String word,int i,String firstLetterMoveDirection,String secondLetterMoveDirection,
										int step,int firstLetterRow,int firstLetterCow,int secondLetterRow,int secondLetterCow){
		switch (firstLetterMoveDirection) {
		case "right":
			firstLetterCow+=step;
			break;
		case "left":
			firstLetterCow-=step;
			break;
		case "down":
			firstLetterRow+=step;
			break;
		case "up":
			firstLetterRow-=step;
			break;
		default:
			break;
		}
		switch (secondLetterMoveDirection) {
		case "right":
			secondLetterCow+=step;
			break;
		case "left":
			secondLetterCow-=step;
			break;
		case "down":
			secondLetterRow+=step;
			break;
		case "up":
			secondLetterRow-=step;
			break;
		default:
			break;
		}
		
		if(firstLetterCow>=6) firstLetterCow=1;
		if(secondLetterCow>=6) secondLetterCow=1;
		if(firstLetterRow>=6) firstLetterRow=1;
		if(secondLetterRow>=6) secondLetterRow=1;
		
		if(i+2!=word.length())
			return word.substring(0,i)+encryptionArray[firstLetterRow][firstLetterCow]+encryptionArray[secondLetterRow][secondLetterCow]+word.substring(i+2,word.length());
		else
			return word.substring(0,i)+encryptionArray[firstLetterRow][firstLetterCow]+encryptionArray[secondLetterRow][secondLetterCow];
	}
	
	public void encrypt(){
		if(this.word.length()%2!=0) this.word+='a';
		this.word=this.word.toUpperCase();
		for(int i=0;i<this.word.length();i+=2){
			int firstLetterRow=positions[(int)(this.word.charAt(i)-'A')]/10%10;
			int firstLetterCow=positions[(int)(this.word.charAt(i)-'A')]%10;
			int secondLetterRow=positions[(int)(this.word.charAt(i+1)-'A')]/10%10;
			int secondLetterCow=positions[(int)(this.word.charAt(i+1)-'A')]%10;
			
			
			String firstLetterMoveDirection="none";
			String secondLetterMoveDirection="none";
			int step=0;
			
			if(firstLetterCow==secondLetterCow && firstLetterRow==secondLetterRow);
			else if(firstLetterCow==secondLetterCow){
				firstLetterMoveDirection="down";
				secondLetterMoveDirection="down";
				step=1;
			}
			else if(firstLetterRow==secondLetterRow){
				firstLetterMoveDirection="right";
				secondLetterMoveDirection="right";
				step=1;
			}
			else if(firstLetterCow<secondLetterCow){
				firstLetterMoveDirection="right";
				secondLetterMoveDirection="left";
				step=Math.abs(firstLetterCow-secondLetterCow);
			}
			else if(firstLetterCow>secondLetterCow){
				firstLetterMoveDirection="left";
				secondLetterMoveDirection="right";
				step=Math.abs(firstLetterCow-secondLetterCow);
			}
			
			this.word=changeLetters(this.word,i,firstLetterMoveDirection,secondLetterMoveDirection,step, firstLetterRow, firstLetterCow, secondLetterRow, secondLetterCow);
		}
	}
	
	public void decrypt(){
		this.encrypt();
	}
}
