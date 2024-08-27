package Hotel;
import java.lang.String;

//-------------------------- INTEFACE FOR CHECK PASSWORD -------------------------

public interface Checkpassword
{
	default boolean check(String password)
	{
//------------------------DECLARE VARIABLES --------------------------------------
		
		String numbers = "0123456789";
		String uppercase = "ABCDEFGHIJKLMNOPQQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacter = "!@#$^&*";
		
		boolean ContainNumbers =  false;
		boolean ContainUpperCase = false;
		boolean ContainLowerCase = false;
		boolean ContainSpecialCharacter = false;
		for(int i = 0; i<password.length(); i++) {

		}
		
//----------------------- CHECK PASSWORD CONTAIN NUMBERS OR NOT ----------------------		
		
		for(int i = 0; i<numbers.length(); i++)
		{
			String j = ""+numbers.charAt(i);
			if(password.contains(j))
			{
				ContainNumbers = true;
				break;
			}
		}
		
//----------------------- CHECK PASSWORD CONTAIN UPPERCASE OR NOT ----------------------
		
		for(int i = 0; i<uppercase.length(); i++)
		{
			String j = ""+uppercase.charAt(i);
			if(password.contains(j))
			{
				ContainUpperCase = true;
				break;
			}
		}
		
//----------------------- CHECK PASSWORD CONTAIN LOWERCASE OR NOT ----------------------
		
		for(int i = 0; i<lowercase.length(); i++)
		{
			String j = ""+lowercase.charAt(i);
			if(password.contains(j))
			{
				ContainLowerCase = true;
				break;
			}
		}
	
//----------------------- CHECK PASSWORD CONTAIN SPECIAL CHARACTER OR NOT ----------------------
	
		for(int i = 0; i<specialCharacter.length(); i++)
		{
			String j = ""+specialCharacter.charAt(i);
			if(password.contains(j))
			{
				ContainSpecialCharacter = true;
				break;
			}
		}
		
		
		if((password.length() >= 8) && ContainNumbers && ContainUpperCase && ContainLowerCase && ContainSpecialCharacter)
			return true;
		
		else
			return false;
	}
}