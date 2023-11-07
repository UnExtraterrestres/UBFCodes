.text	
	# saisie de $t0
	addiu $v0, $0, 5
	syscall
	addiu $t0, $v0, 0
	
	# saisie de $t1
	addiu $v0, $0, 5
	syscall
	addiu $t1, $v0, 0
	
	# structure de controle if
	addiu $a0, $0, '='
	beq $t0, $t1, Fin
	
	addiu $a0, $0, '>'
	slt $t2, $t0, $t1
	beq $t2, $0, Fin
	
	addiu $a0, $0, '<'
Fin:
	addiu $v0, $0, 11
	syscall
