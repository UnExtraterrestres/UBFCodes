.data
	chaine: .asciiz "Hello World"
.text
	addiu $v0,$0,4
	addiu $a0,$0,0x2000
	syscall
	addiu $v0,$0,10
	syscall
	
