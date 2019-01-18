/* This program demonstrates an AVL tree */

#include <stdio.h>
        #include <stdlib.h> /* declares malloc */

        struct node
        {
        char data; /* key */
        struct node *left;
        struct node *right;
        int height; /* height information */
        };

        struct node *root; /* root of the tree */
        struct node *position; /* working position */
        struct node *current; /* traversal buffer node */
//char input[] = { "ALGORITHMS2" };
        char input[] = { "AL" };


        /* Empty the tree and deallocate memory */
        struct node *clear(struct node *r)
        {
        if (r != NULL) {
        clear(r->left);
        clear(r->right);
        free(r);
        }

        return NULL;
        }


        /* Search for a node with key value data in r */
        struct node *search(struct node *r, char data)
        {
        if (r == NULL || r->data == data)
        return r;
        else if (data < r->data)
        return search(r->left, data);
        else /* data > r->data */
        return search(r->right, data);
        }


        /* Search for the node with minimum key value in r */
        struct node *min(struct node *r)
        {
        if (r == NULL || r->left == NULL)
        return r;
        else
        return min(r->left);
        }


        /* Search for the node with maximum key value in r */
        struct node *max(struct node *r)
        {
        if (r == NULL || r->right == NULL)
        return r;
        else
        return max(r->right);
        }


        /* Get the height information of a node */
        int get_height(struct node *n)
        {
        if (!n)
        return -1;
        else
        return n->height;
        }


        /* Get the larger of two different height values */
        int max_height(int h1, int h2)
        {
        return h1 > h2 ? h1 : h2;
        }


        /* Rotate left subtree and root to the right */
        /* Needs: left subtree*/
        struct node *single_rotate_right(struct node *r)
        {
        struct node *tmp; printf("single_rotate_right(%c)\n",r->data);

        /* actual rotation */
        tmp = r->left;
        r->left = tmp->right;
        tmp->right = r;

        /* height update */
        r->height = max_height(get_height(r->left), get_height(r->right));
        tmp->height = max_height(get_height(tmp->left), r->height) + 1;

        return tmp; /* new root */
        }


        /* Rotate right subtree and root to the left */
        /* Needs: right subtree */
        struct node *single_rotate_left(struct node *r)
        {
        struct node *tmp; printf("single_rotate_left(%c)\n",r->data);

        /* actual rotation */
        tmp = r->right;
        r->right = tmp->left;
        tmp->left = r;

        /* height update */
        r->height = max_height(get_height(r->left), get_height(r->right));
        tmp->height = max_height(get_height(tmp->right), r->height) + 1;

        return tmp; /* new root */
        }


        /* Rotate left subtree, then left subtree and root to the right */
        struct node *double_rotate_right(struct node *r)
        {
        printf(">>>> double_rotate_right(%c)\n",r->data);
        r->left = single_rotate_left(r->left);

        return single_rotate_right(r);
        }


        /* Rotate right subtree, then right subtree and root to the left */
        struct node *double_rotate_left(struct node *r)
        {
        printf(">>>> double_rotate_left(%c)\n",r->data);
        r->right = single_rotate_right(r->right);

        return single_rotate_left(r);
        }


        /* Insert a node with data at or after r */
        struct node *insert_node(struct node *r, char data)
        {
        if (!r) { /* (r == NULL) */
        r = (struct node *) malloc(sizeof(struct node)); /* create the node */
        r->left = NULL;
        r->right = NULL;
        r->data = data;
        r->height = 0;
        }

        if (data < r->data) {
        r->left = insert_node(r->left, data);

        if (get_height(r->left) - get_height(r->right) == 2)
        if (data < r->left->data)
        r = single_rotate_right(r);
        else
        r = double_rotate_right(r);
        }
        else if (data > r->data) {
        r->right = insert_node(r->right, data);

        if (get_height(r->right) - get_height(r->left) == 2)
        if (data > r->right->data)
        r = single_rotate_left(r);
        else
        r = double_rotate_left(r);
        }

        r->height = max_height(get_height(r->left), get_height(r->right)) + 1;

        return r;
        }


        /* Get the inorder predecessor of a given node n in r */
        struct node *pred(struct node *r, struct node *n)
        {
        if (n->left != NULL)
        return max(n->left);

        if (!r || r->data == n->data)
        return NULL;
        else if (n->data > r->data) {
        current = r; /* buffer current node */
        pred(r->right, n);
        }
        else /* n->data < r->data) */
        pred(r->left, n);

        return current;
        }


        /* Get the inorder successor of a given node n in r */
        struct node *succ(struct node *r, struct node *n)
        {
        if (n->right != NULL)
        return min(n->right);

        if (!r || r->data == n->data)
        return NULL;
        else if (n->data < r->data) {
        current = r; /* buffer current node */
        succ(r->left, n);
        }
        else /* n->data > r->data) */
        succ(r->right, n);

        return current;
        }


        /* Preorder traversal and output of tree with root r */
        void print_tree_preorder(struct node *r)
        {
        if (r != NULL) {
        printf("%c\n", r->data);
        print_tree_preorder(r->left);
        print_tree_preorder(r->right);
        }
        }


        /* Inorder traversal and output of tree with root r */
        void print_tree_inorder(struct node *r)
        {
        if (r != NULL) {
        print_tree_inorder(r->left);
//        printf("%c\n", r->data);
        printf("%c(%d)\n", r->data, r->height); /* modified ouput with height info */
        print_tree_inorder(r->right);
        }
        }


        /* Postorder traversal and output of tree with root r */
        void print_tree_postorder(struct node *r)
        {
        if (r != NULL) {
        print_tree_postorder(r->left);
        print_tree_postorder(r->right);
        printf("%c\n", r->data);
        }
        }


        /* Tree diagram output (left to right) of tree with root r and level l */
        void print_tree_diagram(struct node *r, int l)
        {
        int i;

        if (!r)
        return;

        print_tree_diagram(r->right, l+1);
        for (i=0; i<l; ++i)
        printf("   ");
        printf("%c\n", r->data);
        print_tree_diagram(r->left, l+1);
        }


        /* Test */
        int main()
        {
        root = NULL; /* initialize the root */

        printf("%s\n\n", input); /* check input */

        int i;
        for (i=0; input[i] != '\0'; i++) {
        root = insert_node(root, input[i]);
        }

        print_tree_inorder(root); /* sequential console output */
        printf("\n\n");
        print_tree_diagram(root,0); /* left to right console output */
        printf("\n\n");

        root = insert_node(root,'O');
        print_tree_inorder(root); /* sequential console output */
        printf("\n\n");
        print_tree_diagram(root,0); /* left to right console output */
        printf("\n\n");

        root = insert_node(root,'M');
        print_tree_inorder(root); /* sequential console output */
        printf("\n\n");
        print_tree_diagram(root,0); /* left to right console output */
        printf("\n\n");

//    printf("%c\n", succ(root,search(root,'L'))->data);
//    printf("\n\n");
//    printf("%c\n", pred(root,search(root,'L'))->data);
//    printf("\n\n");

        return 0; /* return EXIT_SUCCESS */
        }