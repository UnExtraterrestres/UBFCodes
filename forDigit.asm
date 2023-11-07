.text
	addiu $a0, $0, 20
	jal forDigit
	addiu $v0, $0, 11
	syscall
	
	addiu $v0, $0, 10
	syscall
forDigit:
	# $a0 -> digit
	# $v0 -> caractère
	# registre(s) modifié(s) : aucun
	addiu $v0, $a0, '0'
	slti $a0, $a0, 10
	bne $a0, $0, forDigitSuite
	addiu $v0, $v0, 7
forDigitSuite:
	jr $ra
digit:
	# $a0 -> caractere
	# $v0 -> digit
	# registre(s) modifié(s) : aucun
	jr $ra
