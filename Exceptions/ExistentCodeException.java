package Exceptions;


@SuppressWarnings("serial")
public class ExistentCodeException extends Exception{						//exceptie daca exista deja un obiect cu acel cod

	public ExistentCodeException(String s)
	{
		super(s);
	}
	
}


