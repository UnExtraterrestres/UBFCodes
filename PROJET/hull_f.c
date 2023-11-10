#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <assert.h>
#include <math.h>

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


void vecset_create_from(struct vecset *self, const struct vec *data, size_t size)
{
	
	/**
	*Creation d'un nuage de point
	* à partir d'un point spécifié
	*@param self une structure vecset
	*@param data une structure vec
	*@param size un entier
	*@result initialise self avec size fois data 
	*/
	
	self->size = size;
	self->capacity = self->size*2;
	self->data = malloc(sizeof(struct vec)*self->capacity);
	
	for (size_t i = 0; i<size; ++i)
	{
		
		self->data[i] = data[i];
	}
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
    if (self->size >= self->capacity)
    {
        
        self->capacity = self->capacity*2;
        // struct vec *data_add = calloc(self->capacity, (sizeof(int)));
        struct vec *data_add = malloc(sizeof(struct vec)*self->capacity);

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


void afficher_vecset(const struct vecset *self)
{
	
	for (size_t i = 0; i<self->size; ++i)
	{
		
		printf("x : %lf | y : %lf\n", self->data[i].x, self->data[i].y);
	}
	
	printf("Capacity = %ld\n", self->capacity);
	printf("Size = %ld\n", self->size);
}


struct vec *vecset_vec_min(const struct vecset *self)
{
    
    /**
    * Calcul du point le plus à gauche d'un nuage de point
    *@param self une structure vecset
    *@result renvois le point le plus à gauche parmis self
    */
    
    assert(self->size > 0 && "nuage de point vide");
    
    struct vec *res = &self->data[0];
    
    for (size_t i = 1; i<self->size; ++i)
    {
        
        struct vec *tmp = &self->data[i];
        
        if (tmp->x < res->x)
        {
            res = tmp;
        }
    }
    
    return res;
}


struct vec *vecset_vec_max(const struct vecset *self)
{
    
    /**
    * Calcul du point le plus à droite d'un nuage de point
    *@param self une structure vecset
    *@result renvois le point le plus à droite parmis self
    */
    
    assert(self->size > 0 && "nuage de point vide");
    
    struct vec *res = &self->data[0];
    
    for (size_t i = 1; i<self->size; ++i)
    {
        
        struct vec *tmp = &self->data[i];
        
        if (tmp->x > res->x)
        {
            res = tmp;
        }
    }
    
    return res;
}


void all_left_turn(const struct vecset *nuage, const struct vec *A, 
	const struct vec *B, struct vecset *out)
{
	
	/**
	* Calcul de tous les points à gauche d'une droite
	*@param nuage le nuage de point dans lequel lire les points
	*@param A le premier point de la droite
	*@param B le second point de la droite
	*@param out l'ensemble des points résultat
	@result renvois dans out, l'ensemble des points de nuage
	*		à gauche de (AB)
	*/
	
	assert(nuage->size > 0 && "nuage de point vide");
	
	for (size_t i = 0; i<nuage->size; ++i)
	{
		
		struct vec I = nuage->data[i];
		
		if (is_left_turn(A, B, &I))
		{
			vecset_push(out, I);
		}
	}
}


double fabs(double x)
{
    /**
    * Valeur absolue d'un réél
    *@param x un réél
    *@result la valeur absolue de x
    */
    
    return x < 0 ? -x : x;
}


double dist_from_line(const struct vec *A, const struct vec *B,
	const struct vec *C)
{
	
	/**
	* Calcul de distance entre un point et une droite
	*@param A le premier point de la droite
	*@param B le second point de la droite
	*@param C le point à comparer
	*@result renvois la distance entre C et la droite (AB)
	*/
	
	return fabs(cross(A, B, C)) / 
		sqrt((B->x-A->x)*(B->x-A->x)+(B->y-A->y)*(B->y-A->y));
}


struct vec *fur_point(const struct vecset *self, 
	const struct vec *A, const struct vec *B)
{
	
	/**
	* Calcul du point le plus éloigné 
	*@param 
	*/
	
	struct vec *res = NULL;
	double max;
	
	for (size_t i = 0; i<self->size; ++i)
	{
		
		double dist = dist_from_line(A, B, &self->data[i]);
		
		if (dist > max)
		{
			
			max = dist;
			res = &self->data[i];
		}
	}
	
	return res;
}


void quickhull_recursif(const struct vecset *in, 
	struct vec *A, struct vec *B, struct vecset *out)
{
	
	/**
	* QUICKHULL RECURSIF
	*@param in une structure vecset
	*@param A un point
	*@param B un point
	*@param out une structure vecset
	*@result quickhull récursivement
	*/
		
	if (in->size == 0)
	{
		return;
	}
	
	// point le plus éloigné : M
	struct vec *M = fur_point(in, A, B);
	
	// création des sous-nuages
	struct vecset *S1;
	struct vecset *S2;
	vecset_create(S1);
	vecset_create(S2);
	
	all_left_turn(in, A, B, S1);
	all_left_turn(in, B, A, S2);
	
	// appels recursifs
	quickhull_recursif(S1, A, M, out);
	
	vecset_add(out, *M);
	
	quickhull_recursif(S2, M, B, out);
	
	vecset_destroy(S1);
	vecset_destroy(S2);
}


void quickhull(const struct vecset *in, struct vecset *out)
{
	
	/**
	* Calcul de l'enveloppe convexe de in
	*@param in une structure vecset
	*@param out une struture vecset
	*@result met dans out, les points de l'enveloppe convexe de in
	* par l'algorithme de l'enveloppe rapide
	*
	* DETAIL DE L'ALGO
	*sélectionner les deux points aux extrêmes gauche et droite : A et B
	*	les ajouter à l'enveloppe : ils sont forcément dedans
	* --> min et max
	*
	*diviser les points en deux groupes : les points à gauche de (AB) ; S1
	*				et les autres points d'un autre côté ; S2
	* --> find_hull(A, B, S1) et find_hull (B, A, S1)
	*
	*Dans S1 et S2, trouver les points min et max, 
	*	et le point le plus éloiné de (minmax) : M
	*/
	
	
	assert(in->size >= 3 && "nuage de points, in : trop petit");
	
	// selectionner les points min ; A, et max ; B
	struct vec *A = vecset_vec_min(in);
	struct vec *B = vecset_vec_max(in);
	// A et B sont forcément dans l'enveloppe
	vecset_add(out, *A);
	vecset_add(out, *B);
	
	// division du nuage en deux sous-nuages : S1 et S2
	// 	et recherche de l'enveloppe
	struct vecset *S1;
	struct vecset *S2;
	vecset_create(S1);
	vecset_create(S2);
	
	all_left_turn(in, A, B, S1);
	all_left_turn(in, B, A, S2);
	
	// appel récursifs
	quickhull_recursif(S1, A, B, out);
	quickhull_recursif(S2, B, A, out);
	
	vecset_destroy(S1);
	vecset_destroy(S2);
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
	afficher_vecset(tab_enveloppe);

	// envoyer le résultat sur la sortie standard
	printf("%ld\n", tab_enveloppe->size);
	for (size_t i = 0; i < tab_enveloppe->size; i++)
	{
		printf("%f %f\n", tab_enveloppe->data[i].x, 
			tab_enveloppe->data[i].y);
	}
	printf("\n");

	vecset_destroy(tab);
	vecset_destroy(tab_enveloppe);
	free(tab); tab = NULL;
	free(tab_enveloppe); tab_enveloppe = NULL;
	
	return 0;
}

