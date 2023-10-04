#include <stdio.h>


unsigned bitCount(unsigned n)
{
	
	/**
	* @param n un entier non signé
	* @return nombre de bit à 1 de n (non signé)
	*/
	
	int cpt = 0;
	
	while (n != 0)
	{
		
		cpt += n & 1;
		n >>= 1;
	}
	
	return cpt;
}


unsigned char forDigit(unsigned n)
{

	/**
	* @param n un entier non signé
	* @return n convertit en caractère hexa
	* de 0 à 9 n devient un caractère de 0 à 9
	* de 10 à 15 n devient un caractère de A à F
	*/
	
	char res = n + '0';
	
	if (n > 9)
	{
		
		res += 7;
	}
	
	return res;
}


unsigned digit(unsigned char c)
{
	
	/**
	* @param c un caractere non signé
	* @return c en Hexa
	*/
	
	// c entre 0 et 9, ou A et F, ou a et f (inclus)
	if ((c>='0' && '9'>=c))
	{
	
		return c-'0';
	} else if ((c>='A' && 'F'>=c) || (c>='a' && 'f'>=c))
	{
	
		return c-'A'+10;
	}
	
	// sinon c n'est pas valide
	return 3301;
}


void toHexStrong(unsigned n, char *s)
{
	
	/**
	* @param n un Hexa
	* @param *s une chaine de caractère
	* @return change *s tel que n s'affiche :
	* 	sans les zéros à gauche
	* 	avec un espace tous les quatre digits 
	*/
	
	do
	{
	
		*s = forDigit(n & 15);
		
		n >>= 4;
		s++;
	} while (n != 0);
	
	*s = '\0';
}


void toHexString(unsigned n, char *s)
{
	
	if (n == 0)
	{
		*s = '0';
		s++;
	} else
	{
		
		int i = 0;
		do
		{
			if (i == 4)
			{
				*s = '.';
				i = 0;
			} else
			{
			
				*s = forDigit(n & 15);
			}
			
			n >>= 4;
			s++;
			i++;
		} while (n != 0);
	}
	
	*s = '\0';
}


int main(int argc, char *argv[])
{
	
	/* TESTS pour bitCount */
	printf("%u \n", bitCount(0xF0F0F0F0)); // affiche 16
	
	/* TESTS pour forDigit */
	printf("%c \n", forDigit(9)); // affiche '9'
	printf("%c \n", forDigit(10)); // affiche 'A'
	
	/* TESTS pour digit */
	printf("%u \n", digit('9')); // affiche 9
	printf("0x%x \n", digit('A')); // affiche 0xa
	
	/* TESTS pour toHexString */
	char s[23];
	toHexString(0x1234567, s);
	printf("%s \n", s); // affiche 123
	// PB : affiche 321
	
	return 0;
}

