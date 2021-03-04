package Exceptions;

@SuppressWarnings("serial")
public class InexistentCodeException extends Exception {					//exceptie daca nu exista un obiect cu acel cod
		public InexistentCodeException(String s)
		{
			super(s);
		}
	
}
