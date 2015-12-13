
public class Demo {

	public static void main(String[] args) {
		EncryptDecrypt e=new EncryptDecrypt("atex");
		System.out.println(e.getWord());
		e.encrypt();
		System.out.println(e.getWord());
		e.encrypt();
		System.out.println(e.getWord());
	}

}
