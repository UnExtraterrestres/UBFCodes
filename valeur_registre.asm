.data
	nombre: .byte 0x40, 0x41, 0, 0
.text
	addiu $a0, $0, 0x2000
	jal fonction
	addiu $v0, $0, 10
	syscall
fonction:
	addiu $t2, $0, 1
fonction_B:
	lbu $t1, 0($a0)
	srl $t3, $t1, 1
	sb $t3, 0($a0)
	addu $a0, $a0, $t2
	bne $t1, $0, fonction_B
	jr $ra
