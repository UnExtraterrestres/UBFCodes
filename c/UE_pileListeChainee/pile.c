#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>


struct stack_node
{
	int data;
	struct stack_node *next;
};


struct stack
{
	
	struct stack_node *first;
};


void stack_create(struct stack *self)
{
	
	/**
	* @param self une structure stack
	* @return l'initialisation à vide de stack
	*/
	
	self->first = NULL;
}


bool stack_is_empty(const struct stack *self)
{
	
	/**
	* @param self une structure stack
	* @return true si la pile est vide
	*	false sinon
	*/
	
	return self->first == NULL;
}


void stack_push(struct stack *self, int data)
{
	
	/**
	* @param self une structure stack
	* @param data un entier à empiler
	* @return empile data dans self (à ne pas sortir de son contexte)
	* 	data devient un noeud
	*	first de la pile passe en next du noeud de data
	* 	le noeud de data passe en first de la pile
	*/
	
	struct stack_node *noeud_data = (struct stack_node *)calloc(1, sizeof(struct stack_node)); // le free se fait à stack_pop
	noeud_data->data = data;
	
	noeud_data->next = self->first;
	self->first = noeud_data;
}


int stack_top(struct stack *self)
{

	/**
	* @param self une structure stack
	* @return la donnée du haut de la pile
	*/
	
	return self->first->data;
}

void stack_pop(struct stack *self)
{

	/**
	*	A FAIRE
	*
	* @param self une structure stack
	* @return dépile le premier élément de la pile
	* 	first est libéré
	*	next passe en first de la pile
	*/
}


int main(int argc, char **argv)
{
	
	struct stack *pile = (struct stack*) calloc(1, sizeof(struct stack));
	
	/* TESTS pour stack_create */
	stack_create(pile);
	
	/* TESTS pour stack_is_empty */
	printf("La pile est vide ? %d\n", stack_is_empty(pile));
	
	/* TESTS pour stack_push */
	int data = 3301;
	stack_push(pile, data);
	printf("%d est ajouté en haut de la pile : %d\n", data, stack_is_empty(pile));
	
	/* TESTS pour stack_top */
	printf("Le premier élément est : %d\n", stack_top(pile));
	
	/* TESTS pour stack_pop */
	stack_pop(pile);
	printf("La pile est vide ? %d\n", stack_is_empty(pile));
	
	free(pile);
	pile = NULL;
	return 0;
}

