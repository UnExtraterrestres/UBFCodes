#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <assert.h>

#define BUFSIZE 3301

struct vec
{
	/**
	* structure de point
	* vu comme un vecteur depuis l'origine pour simplier les opérations
	* @param x un réél ; l'abscisse du vecteur 
	* @param y un réél ; l'ordonnée du vecteur
	*/
	
	double x;
	double y;
};


double dot(const struct vec *v1, const struct vec *v2)
{
	/**
	* Calul du produit scalaire de deux vecteurs
	* produit scalaire défini comme égal à x1*x2+y1*y2
	* @param v1 une structure vec ; qui contient x1 et y2
	* @param v2 une structure vec ; qui contient x2 et y2
	* @result un réél ; égal à ce produit scalaire
	*/
	
	return (v1->x*v2->x)+(v1->y*v2->y);
}


double cross(const struct vec *p1, const struct vec *p2, const struct vec *p3)
{
	/**
	* Calcul du produit vectoriel 2D de deux vecteurs -->p1p2 et -->p1p3
	* produit vectoriel 2D défini comme égal à (x2-x1)(y3-y1)-(y2-y1)(x3-x1)
	* Permet de determiner si p3 est a gauche ou a droite de (p1p2)
	* Si cross est positif si l'angle formé par [p1p2) et [p1p3) l'est,
	* 	négatif s'il est négatif, nul si alignement
	* @param p1 une structure vec ; le point commun aux deux vecteurs
	* @param p2 une structure vec ; le second point du vecteur -->p1p2
	* @param p3 une structure vec ; le second point du vecteur -->p1p3
	* @result un réél ; égal à ce produit vectoriel 2D
	*/
	
	return (p2->x-p1->x)*(p3->y-p1->y) - (p2->y-p1->y)*(p3->x-p1->x);
}


bool is_left_turn(const struct vec *p1, const struct vec *p2, const struct vec *p3)
{
	/**
	* Verifier si la suite des trois points contitue un tournant à gauche
	* à partir du signe du produit vectoriel 2D
	* @param p1 une structure vec ; point commun des deux vecteurs 
	* @param p2 une structure vec ; le second point du vecteur -->p1p2
	* @param p3 une structure vec ; le second point du vecteur -->p1p3
	* @result retourne vrai ; si cross vire à gauche (donc qu'il est positif)
	* 	retourne faux ; sinon
	*/
	
	return cross(p1, p2, p3) > 0;
}





struct vecset
{
    /**
    * structure de nuage de points
    * vu comme un ensemble de vecteurs (voir struct vec)
    * @param data pointeur une structure vec ; le premier vecteur
    * @param size une grand entier ; le nombre de vecteur du nuage de point
    * @param capacity un grand entier ; le nombre total de vecteur que le nuage peut comprendre
    */
    
    struct vec *data;
    size_t size;
    size_t capacity;
};


void vecset_create(struct vecset *self)
{
    /**
    * Creation d'un nuage de point vide
    * @param self une structure vecset ; 
    * @result initialise self à vide
    */
    
    self->capacity = 10;
    self->size = 0;
    self->data = malloc(sizeof(struct vec)*self->capacity);
}

vecset_create_from(struct vecset *self, struct vec *data, size_t size)
{
	
	
}


void vecset_destroy(struct vecset *self)
{
    /**
    * Destruction d'un nuage de points
    * @param self une structure vecset ;
    * @result détruit self
    */
    
    if (self != NULL)
    {
        
        if (self->size!=0)
        {
            
          struct vec *trash = self->data;
          self->data = NULL;
          free(trash);
        }
    }
}


void vecset_push(struct vecset *self, struct vec p)
{
    /**
    * Empiler un point à un nuage de point
    * @param self une structure vecset ; le nuage de point
    * @param p une structure vec ; le point
    * @result empile p à self
    */
    
    size_t i = 0;
    if (self->size+1 > self->capacity)
    {
        
        self->capacity = self->capacity*2;
        struct vec *data_add = calloc(self->capacity, (sizeof(int)));

        while(i < self->size)
        {
            
            data_add[i] = self->data[i];
            i++;
        }

        free(self->data);
        self->data = data_add;
        self->data[self->size] = p;
        self->size += 1;
    }else
    {
        
        self->data[self->size] = p;
        self->size += 1;
    }
}


void vecset_add(struct vecset *self, struct vec p)
{
    /**
    * Ajouter un point à un nuage de point
    * @param self une structure vecset ; le nuage de point
    * @param p une structure vec ; le point
    * @result empile p à self
    */
    
    vecset_push(self, p);
}


void vecset_pop(struct vecset *self)
{
    /**
    * Depiler un point à un nuage de point
    * @param self une structure vecset ; le nuage de point
    * @result décrémente de 1 le nombre de point du nuage
    */
    
    self->size -= 1;
}


void quickhull(const struct vecset *in, struct vecset *out)
{

    vecset_create(out);

    assert(in->size >= 3);
    
    struct vec *A = &in->data[0];
    struct vec *B = &in->data[0];

    for (size_t i = 1; i < in->size; i++) {
        if (in->data[i].x < A->x) {
            A = &in->data[i];
        } else if (in->data[i].x > B->x) {
            B = &in->data[i];
        }
    }

    struct vecset S1, S2;
    vecset_create(&S1);
    vecset_create(&S2);
    struct vecset R1, R2;
    vecset_create(&R1);
    vecset_create(&R2);

    for (size_t i = 0; i < in->size; i++) {
        if (&in->data[i] != A && &in->data[i] != B) {
            if (is_left_turn(A, B, &in->data[i])) {
                vecset_push(&S1, in->data[i]);
            } else {
                vecset_push(&S2, in->data[i]);
            }
        }
    }

    quickhull(&S1, out);
    quickhull(&S2, out);

    vecset_push(out, *A);

    for (size_t i = 0; i < R1.size; i++) {
        vecset_push(out, R1.data[i]);
    }

    vecset_push(out, *B);

    for (size_t i = 0; i < R2.size; i++) {
        vecset_push(out, R2.data[i]);
    }

    vecset_destroy(&S1);
    vecset_destroy(&S2);
    vecset_destroy(&R1);
    vecset_destroy(&R2);
}


int main()
{
	setbuf(stdout, NULL); // avoid buffering in the output

	char buffer[BUFSIZE];
	fgets(buffer, BUFSIZE, stdin);

	size_t count = strtol(buffer, NULL, 10);

	struct vecset* tab = malloc (sizeof(struct vecset));
	struct vec* temptab = malloc (sizeof(struct vec)*count);
	struct vecset* tab_enveloppe = malloc (sizeof(struct vecset));

	for (size_t i = 0; i < count; i++)
	{
		struct vec p;
		fgets(buffer, BUFSIZE, stdin);
		char *endptr = buffer;
		p.x = strtod(endptr, &endptr);
		p.y = strtod(endptr, &endptr);
		temptab[i] = p;
	}

	// enregistrer l'entrée dans le vecset tab
	vecset_create_from(tab, temptab, count);
	free (temptab);

	/*printf("%ld\n", tab->size);
	for (size_t i = 0; i < tab->size; i++){
	printf("%f %f\n", tab->data[i].x, tab->data[i].y);
	}
	printf("\n");*/

	// faire les enveloppes
	quickhull(tab, tab_enveloppe);

	// envoyer le résultat sur la sortie standard
	printf("%ld\n", tab_enveloppe->size);
	for (size_t i = 0; i < tab_enveloppe->size; i++)
	{
		printf("%f %f\n", tab_enveloppe->data[i].x, tab_enveloppe->data[i].y);
	}
	printf("\n");

	vecset_destroy(tab);
	vecset_destroy(tab_enveloppe);
	free (tab);
	free (tab_enveloppe);
	
	return 0;
}

