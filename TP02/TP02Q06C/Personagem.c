#include <stdio.h>
#include <stdlib.h>

// ==================================== Definitions ================================== //

#define N_JSONS 86
#define MAXTAM 6

typedef struct SWCharacter_s SWCharacter;

// ==================================== Prototypes ================================== //

size_t str_len(const char *const str);
short str_equals(const char *const str, const char *const other);
char *str_substring(const char *const str, const size_t start, const size_t end);
char *str_clone(const char *const str);
void str_remove_all(char *const str, const char c);
void file_to_string(const char *const path, char *const str);
char *json_substring(const char *const str, const char *const key, size_t *const index);
int parse_int(const char *const str);
double parse_double(const char *str);
short isFim(const char *const str);
int hash(const char *const comando);

SWCharacter SWCharacter_new();
SWCharacter SWCharacter_from_file(const char *const path);
SWCharacter swc_clone(const SWCharacter *const self);
void swc_print(const SWCharacter *const self);
void swc_free(SWCharacter *const self, const size_t len);

// ==================================== Utils ================================== //

int hash(const char *const comando)
{
    int hash = 0;
    for (int i = 0; i < str_len(comando); i++)
    {
        hash += (int)comando[i];
    }
    return hash;
}

size_t str_len(const char *const str)
{
    size_t len = 0;

    while (str[len])
        len++;

    return len;
}

short str_equals(const char *const str, const char *const other)
{
    size_t i = 0;
    short equals = 1;

    while (equals && str[i] && other[i])
    {
        equals = str[i] == other[i];
        i++;
    }

    return equals && !(str[i] || other[i]);
}

char *str_substring(const char *const str, const size_t start, const size_t end)
{
    size_t i = 0;
    char *substr = (char *)malloc((end - start + 1) * sizeof(char));

    while (i < end - start)
    {
        substr[i] = str[start + i];
        substr[++i] = '\0';
    }

    return substr;
}

char *str_clone(const char *const str)
{
    size_t len = str_len(str) + 1;
    char *copy = (char *)malloc(len * sizeof(char));
    for (size_t i = 0; i < len; i++)
        copy[i] = str[i];
    return copy;
}

void str_remove_all(char *const str, const char c)
{
    size_t len = str_len(str);
    size_t i = 0;

    while (i < len && str[i] != c)
        i++;

    for (size_t j = i; j < len; i++, j++)
    {
        if (str[i] == c)
            j++;
        str[i] = str[j];
    }

    str[i] = '\0';
}

void file_to_string(const char *const path, char *const str)
{
    FILE *f = fopen(path, "r");
    fscanf(f, " %1000[^\n]", str);
    fclose(f);
}

char *json_substring(const char *const str, const char *const key, size_t *const index)
{
    size_t start = *index + str_len(key) + 4;
    *index = start;
    while (str[++*index] != '\'')
        ;
    *index += 4;
    return str_substring(str, start, *index - 4);
}

int parse_int(const char *const str)
{
    int a = 0;
    int b = 1;

    for (int i = str_len(str) - 1; i >= 0; i--, b *= 10)
        a += (str[i] - 48) * b;

    return a;
}

double parse_double(const char *str)
{
    double value = 0;
    int dot = 0;
    double scale = 1;
    int negative = 0;

    if (*str == '-')
    {
        str++;
        negative = 1;
    }

    while (*str)
    {
        if (dot)
        {
            scale = scale / 10;
            value = value + (*str - 48) * scale;
        }
        else
        {
            if (*str == '.')
                dot++;
            else
                value = value * 10.0 + (*str - 48);
        }

        str++;
    }

    return negative ? -value : value;
}

short isFim(const char *const str)
{
    return str_equals(str, "FIM");
}

// ==================================== Structs ================================== //

struct SWCharacter_s
{
    char *name;
    int height;
    double mass;
    char *hair_color;
    char *skin_color;
    char *eye_color;
    char *birth_year;
    char *gender;
    char *homeworld;
};

// ==================================== Constructors ================================== //

SWCharacter SWCharacter_new()
{
    SWCharacter self;

    self.name = NULL;
    self.height = 0;
    self.mass = 0;
    self.hair_color = NULL;
    self.skin_color = NULL;
    self.eye_color = NULL;
    self.birth_year = NULL;
    self.gender = NULL;
    self.homeworld = NULL;

    return self;
}

SWCharacter SWCharacter_from_file(const char *const path)
{
    char *json = (char *)malloc(1000 * sizeof(char));
    SWCharacter self;
    char *str = NULL;
    size_t index = 2;

    file_to_string(path, json);

    self.name = json_substring(json, "name", &index);

    str = json_substring(json, "height", &index);
    self.height = str_equals(str, "unknown") ? 0 : parse_int(str);
    free(str);

    str = json_substring(json, "mass", &index);
    str_remove_all(str, ',');
    self.mass = str_equals(str, "unknown") ? 0 : parse_double(str);
    free(str);

    self.hair_color = json_substring(json, "hair_color", &index);
    self.skin_color = json_substring(json, "skin_color", &index);
    self.eye_color = json_substring(json, "eye_color", &index);
    self.birth_year = json_substring(json, "birth_year", &index);
    self.gender = json_substring(json, "gender", &index);
    self.homeworld = json_substring(json, "homeworld", &index);

    free(json_substring(json, "name", &index));
    free(json_substring(json, "height", &index));
    free(json_substring(json, "mass", &index));
    free(json_substring(json, "hair_color", &index));
    free(json_substring(json, "skin_color", &index));

    return self;
}

// ==================================== SWCharacter Methods ================================== //

SWCharacter swc_clone(const SWCharacter *const self)
{
    SWCharacter other;
    /**
     * other é um dado, portanto se usa ponto
     * self é um endereço de memória, portanto se usa seta. Só se usa seta em Struct
     * a seta é um ponteiro de ponteiro
     */
    other.name = str_clone(self->name);
    other.height = self->height;
    other.mass = self->mass;
    other.hair_color = str_clone(self->hair_color);
    other.skin_color = str_clone(self->skin_color);
    other.eye_color = str_clone(self->eye_color);
    other.birth_year = str_clone(self->birth_year);
    other.gender = str_clone(self->gender);
    other.homeworld = str_clone(self->homeworld);

    return other;
}

void swc_print(const SWCharacter *const self)
{
    printf(" ## ");
    printf("%s ## ", self->name);
    printf("%d ## ", self->height);

    if (self->mass == (int)self->mass)
    {
        printf("%d ## ", (int)self->mass);
    }
    else
    {
        printf("%.1lf ## ", self->mass);
    }

    printf("%s ## ", self->hair_color);
    printf("%s ## ", self->skin_color);
    printf("%s ## ", self->eye_color);
    printf("%s ## ", self->birth_year);
    printf("%s ## ", self->gender);
    printf("%s ## ", self->homeworld);
    printf("\n");
}

void swc_free(SWCharacter *const self, const size_t len)
{
    if (self)
    {
        for (size_t i = 0; i < len; i++)
        {
            if (self[i].name)
                free(self[i].name);
            if (self[i].hair_color)
                free(self[i].hair_color);
            if (self[i].skin_color)
                free(self[i].skin_color);
            if (self[i].eye_color)
                free(self[i].eye_color);
            if (self[i].gender)
                free(self[i].gender);
            if (self[i].birth_year)
                free(self[i].birth_year);
            if (self[i].homeworld)
                free(self[i].homeworld);
        }
        free(self);
    }
}

// ==================================== Lista Circular ================================= //

typedef struct lista
{

    SWCharacter array[MAXTAM + 1];
    int primeiro, ultimo;
} lista;

void start(lista *l)
{
    l->primeiro = l->ultimo = 0;
}

int my_floor(double media)
{
    return (int)media;
}

int my_ceil(double media)
{
    return (int)media + 1;
}

int my_round(double media)
{
    int result = 0;
    if (media - (int)media >= 0.5)
    {
        result = my_ceil(media);
    }
    else
    {
        result = my_floor(media);
    }
    return result;
}

int media(lista *l)
{
    int i = l->primeiro;
    int contador = 0;
    double media = 0;

    while (i != l->ultimo)
    {
        // swc_print(&l->array[i]);
        //printf("%d\t", l->array[i].height);
        media = media + l->array[i].height;
        contador++;
        i = (i + 1) % (MAXTAM);
    }
    //printf("\n");
    //printf("contador: %d\n", contador);
    return my_round(media / contador);
}

SWCharacter remover(lista *l)
{

    if (l->primeiro == l->ultimo)
        exit(1);

    SWCharacter resp = l->array[l->primeiro];
    l->primeiro = (l->primeiro + 1) % MAXTAM;

    return resp;
}

void inserir(SWCharacter x, lista *l)
{
    if (((l->ultimo + 1) % MAXTAM) == l->primeiro)
        remover(l);

    l->array[l->ultimo] = x;
    l->ultimo = (l->ultimo + 1) % MAXTAM;
}

void mostrar(lista *l)
{
    int i = l->primeiro;
    while (i != l->ultimo)
    {
        swc_print(&l->array[i]);
        i = (i + 1) % 6;
    }
}

// ==================================== Main ================================== //

int main()
{

    SWCharacter *array = (SWCharacter *)malloc(N_JSONS * sizeof(SWCharacter));
    size_t len = 0;
    char *str = (char *)malloc(100 * sizeof(char));

    lista l;
    start(&l);

    scanf(" %100[^\n]", str);
    while (!isFim(str))
    {
        SWCharacter aux;
        aux = SWCharacter_from_file(str);
        // array[len++] = SWCharacter_from_file(str);
        array[len++] = aux;
        inserir(aux, &l);
        printf("%d\n", media(&l));
        scanf(" %100[^\n]", str);
    }

    // mostrar(&l);
    int n = 0;
    scanf("%d", &n);
    fflush(stdin);

    char *str2 = (char *)malloc(100 * sizeof(char));
    scanf(" %100[^\n]", str2);
    // printf("str2: %s\n", str2);
    fflush(stdin);

    char *comando = (char *)calloc(100 + 1, sizeof(char));
    SWCharacter aux2;
    // char* aux3 = (char*)calloc(100+1, sizeof(char));
    int aux3 = 0;

    for (int i = 0; i < n; i++)
    {
        comando = str_substring(str2, 0, 1);

        // Switch Case em C não aceita string, então tive de fazer hashing.
        switch (hash(comando))
        {

        // 73 = I (Inserir)
        case 73:
            aux2 = SWCharacter_from_file(str_substring(str2, 2, str_len(str2)));
            // printf("%s\n", str_substring(str2, 2, str_len(str2)));
            inserir(aux2, &l);
            printf("%d\n", media(&l));
            break;

        // 82 = R (Remover)
        case 82:
            printf("(R) %s\n", remover(&l).name);
            break;
        }

        scanf(" %100[^\n]", str2);
        fflush(stdin);
    }

    mostrar(&l);

    // sempre quando fizer malloc dar free
    swc_free(array, len);
    free(str);
    free(str2);
    free(comando);

    return 0;
}