#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

//PARTIE 1=
struct vec {
    double x;
    double y;
};

double dot(const struct vec *v1, const struct vec *v2){ //1.1
    return (v1->x*v2->x)*(v1->y*v2->y);
}

double cross(const struct vec *p1, const struct vec *p2, const struct vec *p3){ //1.2
    return ((p2->x-p1->x)*(p3->y-p1->y))-((p2->y-p1->y)*(p3->x-p1->x));
}

bool is_left_turn(const struct vec *p1, const struct vec *p2, const struct vec *p3){ //1.3
    double l_or_r=cross(p1, p2, p3);
    if (l_or_r>0){
        return true;
    }
    return false;
}

//PARTIE 2
struct vecset {
    struct vec *data;
    size_t size;
    size_t capacity;
};

void vecset_create(struct vecset *self){ //2.1
    self->data=(int *)(malloc(sizeof(int)*10));
    self->capacity=10;
    self->size=0;
}

void vecset_destroy(struct vecset *self){ //2.2
    if (self!=NULL){
    if (self->size!=0){
      int *trash = self->data;
      self->data=NULL;
      free(trash);
    }
  }
}

void vecset_add(struct vecset *self, struct vec p){ //2.3
    vecset_push(self, p);
}

typedef int (*comp_func_t)(const struct vec *p1, const struct vec *p2, const void *ctx){ //2.4

}

void vecset_push(struct vecset *self, struct vec p){ //2.7
    size_t i=0;
    if (self->size+1>self->capacity){
        self->capacity=self->capacity*2;
        int *data_add=(int *)(calloc(self->capacity, (sizeof(int *))));

        while(i<self->size){
            data_add[i]=self->data[i];
            i++;
        }

        free(self->data);
        self->data=data_add;
        self->data[self->size]=p;
        self->size+=1;
    }else{
        self->data[self->size]=p;
        self->size+=1;
    }
}

void vecset_pop(struct vecset *self){ //2.8 
    self->size-=1;
}

const struct vec *vecset_top(const struct vecset *self){ //2.9
    if (self->size!=0){
        return data[0];
    }
    return NULL;
}

const struct vec *vecset_second(const struct vecset *self){ //2.10
    if ((self->size!=0)&&(self->size!=1)){
        return data[1];
    }
    return NULL;
}
