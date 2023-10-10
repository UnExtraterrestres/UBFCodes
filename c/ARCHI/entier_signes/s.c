#include <stdio.h>


int bitCount(int n)
{
	
	int cpt = 1 & (n>>31); // ne compte pas le signe
	
	while (n != 0)
	{
		
		cpt += n & 1; // compte le bit de poids faible
		n = (n & 0x7FFFFFFF) >> 1;
	}
	
	return cpt;
}


int absolue(int n)
{
	
	if ((n >> 31) != 0)
	{
		
		return ~n+1;
	}
	
	return n;
}


void toStringBase(int n, char *s, int base)
{
	
	
	
}


void testToStringBase(int n, char *s, int base)
{
	
	toStringBase(n, s, base);
	printf("Test toStringBase : ");
}


int parseInt(char *s, int base)
{
	
	return 0;
}


int main(int argc, char **argv)
{
	
	int n0 = 0x8000000;
	int n1 = -1;
	
	/* TESTS pour bitCount */
	printf("nb bits de %d = %d\n", n0, bitCount(n0));
	printf("nb bits de %d = %d\n", n1, bitCount(n1));
	
	/* TESTS pour absolue */
	printf("|%d| = %d\n", n0, absolue(n0));
	printf("|%d| = %d\n", n1, absolue(n1));
	
	/* TESTS pour toString */
	char *s[23];
	testToStringBase(0, s, 10);
	testToStringBase(0x123, s, 10);
	testToStringBase(0xFFFFFFFF, s, 10);
	testToStringBase(0x80000000, s, 16);
	testToStringBase(0x7FFFFFFF, s, 16);
	
	return 0;
}

