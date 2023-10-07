#include <stdlib.h>
#include <stdbool.h>


struct deque
{
	
	size_t capacity;
	size_t start;
	size_t end;
	int *data;
};


void deque_create(struct deque *self)
{
	
	/**
	* @param self structure file double
	* @return l'initialisation de self
	*/
	
	self->capacity = 1;
	self->start = self->end = 0;
	self->data = calloc(self->capacity, sizeof(int));
}


bool deque_is_empty(const struct deque *self)
{

	/**
	* @param self structure file double
	* @return true si self est vide
	*	false sinon
	*/
	
	return self->start == self->end;
}


size_t next(const struct deque *self, size_t i)
{
	
	/**
	* @param self structure file double
	* @param i entier
	* @return l'indice en aval de i
	*/
	
	return (i+1) % self->capacity;
}


size_t prev(const struct deque *self, size_t i)
{
	
	/**
	* @param self structure file double
	* @param i entier
	* @return l'indice en amont de i
	*/
	
	if (i == 0)
	{
		return self->capacity-i;
	}
	
	return i-1;
}


void deque_grow(struct deque *self)
{
	
	/**
	* @param self structure file double
	* @return l'agrandissement mémoire de self
	*/
	
	size_t capacity = self->capacity*2;
	int *data = calloc(capacity, sizeof(int));
	
	if (self->start <= self->end)
	{
		
		size_t size = self->end-self->start;
		memcpy(data+self->start,
			self->data+self->start,
			size*sizeof(int));
	} else
	{
		
		size_t size = self->capacity-self->start;
		memcpy(data, self->data+self->start,
			size*sizeof(int));
		memcpy(data+size, self->data,
			self->end*sizeof(int));
	}
	
	free(self->data);
	self->data = data;
	self->capacity = capacity;
}


void deque_push(struct deque *self, int value)
{
	
	/**
	* @param self structure file double
	* @param value entier
	* @return ajoute value au début de self
	*/
	
	if (next(self, self->end) == self->start)
	{
		
		deque_grow(self);
	}
	
	self->start = prev(self, self->start);
	self->data[self->start] = value;
}


void deque_inject(struct deque *self, int value)
{
	
	/**
	* @param self structure file double
	* @param value entier
	* @return ajoute value à la fin de self
	*/
	
	if (next(self, self->end) == self->start)
	{
		
		deque_grow(self);
	}
	
	self->data[self->end] = value;
	self->end = next(self, self->end);
}


void deque_pop(struct deque *self)
{
	
	/**
	* @param self structure file double
	* @return supprime la valeur au début de self
	*/
	
	assert(!deque_is_empty(self));
	self->start = next(self, self->start);
}


void deque_eject(struct deque *self)
{
	
	/**
	* @param self structure file double
	* @return supprime la valeur à la fin de self
	*/
	
	assert(!deque_is_empty(self));
	self->end = prev(self, self->end);
}


int deque_front(const struct deque *self)
{
	
	/**
	* @param self structure file double
	* @return la valeur au début de self
	*/
	
	assert(!deque_is_empty(self));
	return self->data[self->start];
}


int deque_back(const struct deque *self)
{
	
	/**
	* @param self structure file double
	* @return la valeur à la fin de self
	*/
	
	assert(!deque_is_empty(self));
	return self->data[self->end];
}


void deque_printf(const struct deque *self)
{
	
	/**
	* @param self une structure file double
	* @return l'affichage dans la console des arguments de self
	*/
	
	printf("File :\n");
	printf("Capacity : %ld\n", self->capacity);
	printf("Start : %ld\n", self->start);
	printf("End : %ld\n", self->end);
	printf("Data : %d\n", self->data);
}


int main(int argc, char **argv)
{
	
	struct deque file = calloc(1, sizeof(struct deque));
	
	/* TESTS pour deque_create */
	deque_create(file);
	deque_printf(file);
	
	/* TESTS pour deque_is_empty */
	printf("file est vide : %d\n", deque_is_empty(file));
	
	/* TESTS pour deque_push */
	deque_push(file, 3301);
	printf("Première valeure de la file : %d\n", deque_front(file));
	
	/* TESTS pour deque_inject */
	deque_inject(file, 42);
	printf("Dernière valeure de la file : %d\n", deque_back(file));
	
	/* TESTS pour deque_pop et deque_eject */
	deque_pop(file);
	deque_eject(file);
	printf("file est vide : %d\n", deque_is_empty(file));
	
	return 0;
}

