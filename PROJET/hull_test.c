#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <assert.h>


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


int main(int argc, char **argv)
{

	/* STRUCTURE POUR LA GEOMETRIE */
    // struct vec
    struct vec *v0 = malloc(sizeof(struct vec));
    struct vec *v1 = malloc(sizeof(struct vec));
    struct vec *v2 = malloc(sizeof(struct vec));
    
    v0->x = 0.0;
    v0->y = 0.0;
    v1->x = 1.0;
    v1->y = 1.0;
    v2->x = -10.0;
    v2->y = 36.0;
    
    printf("v0 = %lf %lf\n", v0->x, v0->y);
    printf("v1 = %lf %lf\n", v1->x, v1->y);
    printf("v2 = %lf %lf\n", v2->x, v2->y);
    
    // dot
    double d = dot(v2, v1);
    printf("dot 21 : %lf\n", d);
    
    // cross
    double c = cross(v0, v1 ,v2);
    printf("cross 012 : %lf\n", c);
    // is_left_turn
    bool lt = is_left_turn(v0, v1, v2);
    printf("ilt = %d\n", lt);
	
    /* ENSEMBLE DE POINTS */
    // vecset
    struct vecset *nuage = malloc(sizeof(struct vecset));
    
    // vecset_create
    vecset_create(nuage);
    
    // vecset_destroy
    // voir free
    
    // vecset_push
    // vecset_add
    vecset_push(nuage, *v0);
    printf("%lf\n", nuage->data[0].x);
    printf("%ld %ld\n", nuage->capacity, nuage->size);
    
    vecset_push(nuage, *v1);
    printf("%lf\n", nuage->data[1].x);
    printf("%ld %ld\n", nuage->capacity, nuage->size);
    
    // type def comp
    // vecset_max
    // vecset_min
    // vecset_sort
    // vecset_pop
    vecset_pop(nuage);
    printf("%ld %ld\n", nuage->capacity, nuage->size);
    
    // vecset_top
    // vecset_second

    /* MARCHE DE JARVIS */

    /* PARCOURS DE GRAHAM */

    /* ENVELOPPE RAPIDE */

    /* PILOTE */
	
	free(v0);
	free(v1);
	free(v2);
	vecset_destroy(nuage);
	
	return 0;
}

