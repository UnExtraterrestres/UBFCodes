#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

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
	
	return (v1->x*v2->x)*(v1->y*v2->y);
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
	
	return cross(p1, p2, p3);
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


typedef int (*comp_func_t)(const struct vec *p1, const struct vec *p2, const void *ctx)
{
    /**
    * Comparaison de deux points
    * @param p1 une structure vec ; le premier point
    * @param p2 une structure vec ; le second point
    * @param ctx un contexte
    * @result un entier négatif ; si p1 est plus petit que p2,
    *     un entier positif si p1 est plus grand que p2,
    *     0 ; sinon
    */
}


void vecset_create(struct vecset *self)
{
    /**
    * Creation d'un nuage de point vide
    * @param self une structure vecset ; 
    * @result initialise self à vide
    */
    
    self->data=(int *)(malloc(sizeof(int)*10));
    self->capacity=10;
    self->size=0;
}


void vecset_destroy(struct vecset *self)
{
    /**
    * Destruction d'un nuage de points
    * @param self une structure vecset ;
    * @result détruit self
    */
    
    if (self!=NULL)
    {
        
        if (self->size!=0)
        {
            
          int *trash = self->data;
          self->data=NULL;
          free(trash);
        }
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


const struct vec *vecset_max(const struct vecset *self, comp_func_t func, const void *ctx)
{
    /**
    * Recherche du plus grand point dans un nuage de point
    * @param self une structure vecset ; le nuage de point
    * @param func une fonction ; typedef int (*comp_func_t)
    * @param ctx un contexte ;
    * @result renvois le plus grand point parmis self
    */
    
    struct vec *vec_max = (struct vec *)(malloc(sizeof(struct vec *)));
    vec_max = self->data[0];
    
    for (size_t i = 0; i<self->size-1; ++i)
    {
        
        if (func(data[i], data[i+1], ctx) < 0)
        {
        
            vec_max = self->data[i+1];
        }
    }
    
    return vec_max;
}


const struct vec *vecset_min(const struct vecset *self, comp_func_t func, const void *ctx)
{
    /**
    * Recherche du plus petit point dans un nuage de point
    * @param self une structure vecset ; le nuage de point
    * @param func une fonction ; typedef int (*comp_func_t)
    * @param ctx un contexte ;
    * @result renvois le plus petit point parmis self
    */
    
    struct vec *vec_max = (struct vec *)(malloc(sizeof(struct vec *)));
    vec_max = self->data[0];
    
    for (size_t i = 0; i<self->size-1; ++i)
    {
        if (func(data[i], data[i+1], ctx) > 0)
        {
            vec_max = self->data[i+1];
        }
    }
    
    return vec_max;
}


void vecset_sort(struct vecset *self, comp_func_t func, const void *ctx) // O(n²) MINIMUM => A CHANGER !!!!!!!
{
    /**
    * Tri d'un nuage de point
    * @param self une structure vecset ; le nuage de point
    * @param func une fonction ; la fonction de comparaison
    * @param ctx un contexte ;
    * @result trie self suivant le fonction de comparaison func
    */
    
    struct vec *temp = (struct vec *)(malloc(sizeof(struct vec *)));
    for (size_t i = 0; i<self->size; ++i)
    {
        for (size_t j = self->size-1; j>i; --j)
        {
            
            if (func(data[j], data[j-1], ctx) < 0)
            {
                
                temp = self->data[j];
                self->data[j] = self->data[j-1];
                self->data[j-1] = temp;
            }
        }
    }

    free(temp);
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
        int *data_add=(int *)(calloc(self->capacity, (sizeof(int *))));

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


void vecset_pop(struct vecset *self)
{
    /**
    * Depiler un point à un nuage de point
    * @param self une structure vecset ; le nuage de point
    * @result décrémente de 1 le nombre de point du nuage
    */
    
    self->size -= 1;
}


const struct vec *vecset_top(const struct vecset *self)
{
    /**
    * Recherche du premier élément de la pile
    * @param self une structure vecset ; le nuage de point
    * @result retourne le point d'indice 0 de self
    */
    
    if (self->size > 0)
    {
        
        return data[0];
    }
    
    return NULL;
}


const struct vec *vecset_second(const struct vecset *self)
{

    /**
    * Recherche du second élément de la pile
    * @param self une structure vecset ; le nuage de point
    * @result retourne le point d'indice 1 de self
    */
    
    if (self->size > 1)
    {
        
        return data[1];
    }
    
    return NULL;
}

void jarvis_march(const struct vecset *in, struct vecset *out)
{

}


void graham_scan(const struct vecset *in, struct vecset *out)
{

}

void quikhull(const struct vecset *in, struct vecset *out)
{

}

int main(int argc, char **argv)
{

	setbuf(stdout, NULL);

	char buffer[BUFSIZE];
	fgets(buffer, BUFSIZE, stdin);

	size_t count = strtol(buffer, NULL, 10);

	for (size_t i = 0; i<count; ++i)
	{
		struct vec p;

		fgets(buffer, BUFSIZE, stdin);

		char *endptr = buffer;
		p.x = strtod(endptr, &endptr);
		p.y = strtod(endptr, &endptr);

		// faire le truc avec p là
		// PS : désolé pour la non chalance du commentaire au dessus XD
	}

	return 0;
}
