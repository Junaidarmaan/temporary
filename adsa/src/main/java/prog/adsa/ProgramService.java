package prog.adsa;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {

    public String heapSort() {
        // Include your Heap Sort code here
        String response = new String();

        response = """
                                #include <stdio.h>

                // Function to swap two elements
                void swap(int *a, int *b) {
                    int temp = *a;
                    *a = *b;
                    *b = temp;
                }

                // Function to heapify a subtree rooted at index 'i' in an array of size 'n'
                void heapify(int arr[], int n, int i) {
                    int largest = i;        // Initialize largest as root
                    int left = 2 * i + 1;   // Left child
                    int right = 2 * i + 2;  // Right child

                    // Check if left child is larger than root
                    if (left < n && arr[left] > arr[largest])
                        largest = left;

                    // Check if right child is larger than the largest so far
                    if (right < n && arr[right] > arr[largest])
                        largest = right;

                    // If the largest is not the root, swap and continue heapifying
                    if (largest != i) {
                        swap(&arr[i], &arr[largest]);
                        heapify(arr, n, largest);
                    }
                }

                // Function to perform heap sort
                void heapSort(int arr[], int n) {
                    // Build max heap by heapifying all non-leaf nodes
                    for (int i = n / 2 - 1; i >= 0; i--)
                        heapify(arr, n, i);

                    // Extract elements from heap one by one
                    for (int i = n - 1; i > 0; i--) {
                        // Move current root to end
                        swap(&arr[0], &arr[i]);

                        // Heapify the reduced heap
                        heapify(arr, i, 0);
                    }
                }

                // Function to print the array
                void printArray(int arr[], int n) {
                    for (int i = 0; i < n; i++)
                        printf("%d ", arr[i]);
                    printf("\n");
                }

                int main() {
                    int arr[20], n, i;

                    printf("Enter number of elements: ");
                    scanf("%d", &n);

                    printf("Enter elements:\n");
                    for (i = 0; i < n; i++)
                        scanf("%d", &arr[i]);

                    // Perform heap sort
                    heapSort(arr, n);

                    printf("Sorted array is:\n");
                    printArray(arr, n);

                    return 0;
                }

                                """;
        return response;
    }

    public String breadthFirstSearch() {
        // Include your BFS code here
        String response = new String();
        response = """
                                #include <stdio.h>

                #define MAX 20

                int queue[MAX], front = -1, rear = -1;
                int visited[MAX];  // Array to keep track of visited nodes

                // Function to add an element to the queue
                void enqueue(int vertex) {
                    if (rear == MAX - 1) {
                        printf("Queue Overflow\n");
                    } else {
                        if (front == -1)  // If queue is empty, set front to 0
                            front = 0;
                        rear++;
                        queue[rear] = vertex;
                    }
                }

                // Function to remove an element from the queue
                int dequeue() {
                    int vertex = -1;
                    if (front == -1 || front > rear) {
                        printf("Queue Underflow\n");
                    } else {
                        vertex = queue[front];
                        front++;
                    }
                    return vertex;
                }

                // Function to perform BFS on a graph represented by an adjacency matrix
                void BFS(int adjMatrix[MAX][MAX], int startVertex, int n) {
                    int i;

                    enqueue(startVertex);      // Enqueue the starting vertex
                    visited[startVertex] = 1;  // Mark the starting vertex as visited

                    printf("BFS Traversal: ");

                    while (front <= rear) {
                        int currentVertex = dequeue();  // Dequeue a vertex
                        printf("%d ", currentVertex);   // Print the vertex

                        // Visit all adjacent vertices of the current vertex
                        for (i = 0; i < n; i++) {
                            if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                                enqueue(i);        // Enqueue the adjacent vertex
                                visited[i] = 1;    // Mark it as visited
                            }
                        }
                    }
                    printf("\n");
                }

                int main() {
                    int adjMatrix[MAX][MAX];
                    int n, i, j, startVertex;

                    printf("Enter the number of vertices: ");
                    scanf("%d", &n);

                    // Initialize the visited array to 0
                    for (i = 0; i < n; i++)
                        visited[i] = 0;

                    printf("Enter the adjacency matrix:\n");
                    for (i = 0; i < n; i++) {
                        for (j = 0; j < n; j++) {
                            scanf("%d", &adjMatrix[i][j]);
                        }
                    }

                    printf("Enter the starting vertex (0 to %d): ", n - 1);
                    scanf("%d", &startVertex);

                    // Perform BFS
                    BFS(adjMatrix, startVertex, n);

                    return 0;
                }

                                """;
        return response;
    }

    public String depthFirstSearch() {
        // Include your DFS code here
        String response = new String();
        response = """
                                #include <stdio.h>

                #define MAX 20

                int visited[MAX]; // Array to keep track of visited nodes

                // Function to perform DFS on a graph represented by an adjacency matrix
                void DFS(int adjMatrix[MAX][MAX], int vertex, int n) {
                    visited[vertex] = 1; // Mark the current vertex as visited
                    printf("%d ", vertex); // Print the vertex

                    // Visit all adjacent vertices of the current vertex
                    for (int i = 0; i < n; i++) {
                        if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                            DFS(adjMatrix, i, n); // Recursive call for the adjacent vertex
                        }
                    }
                }

                int main() {
                    int adjMatrix[MAX][MAX];
                    int n, startVertex;

                    printf("Enter the number of vertices: ");
                    scanf("%d", &n);

                    // Initialize the visited array to 0
                    for (int i = 0; i < n; i++)
                        visited[i] = 0;

                    printf("Enter the adjacency matrix:\n");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            scanf("%d", &adjMatrix[i][j]);
                        }
                    }

                    printf("Enter the starting vertex (0 to %d): ", n - 1);
                    scanf("%d", &startVertex);

                    // Perform DFS
                    printf("DFS Traversal: ");
                    DFS(adjMatrix, startVertex, n);
                    printf("\n");

                    return 0;
                }

                                """;
        return response;
    }

    public String bruteForceStringMatching() {
        // Include your Brute Force String Matching code here
        String response = new String();
        response =
            """
                #include <stdio.h>
#include <conio.h>
#include <string.h>

void bruteForceStringMatch(char text[], char pattern[]) {
    int n = strlen(text);      // Length of the text
    int m = strlen(pattern);   // Length of the pattern
    int i, j;

    printf("Matching positions: ");
    for (i = 0; i <= n - m; i++) {
        j = 0;

        // Check for a match
        while (j < m && text[i + j] == pattern[j]) {
            j++;
        }

        // If the whole pattern matches
        if (j == m) {
            printf("%d ", i + 1); // +1 for 1-based indexing
        }
    }
    printf("\n");
}

void main() {
    char text[100], pattern[50];

    clrscr(); // Clear screen (specific to Turbo C)

    // Input the text
    printf("Enter the text: ");
    gets(text); // Turbo C compatible input for strings

    // Input the pattern
    printf("Enter the pattern: ");
    gets(pattern);

    // Call the string matching function
    bruteForceStringMatch(text, pattern);

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }

    public String boyerMooreStringMatching() {
        // Include your Boyer-Moore String Matching code here
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>
#include <string.h>

#define ASCII_SIZE 256

// Function to preprocess the pattern and create the bad character table
void badCharHeuristic(char pattern[], int m, int badChar[]) {
    int i;

    // Initialize all occurrences as -1
    for (i = 0; i < ASCII_SIZE; i++) {
        badChar[i] = -1;
    }

    // Fill the actual value of the last occurrence of each character in the pattern
    for (i = 0; i < m; i++) {
        badChar[(int)pattern[i]] = i;
    }
}

// Boyer-Moore string matching algorithm
void boyerMooreSearch(char text[], char pattern[]) {
    int n = strlen(text);      // Length of the text
    int m = strlen(pattern);   // Length of the pattern
    int badChar[ASCII_SIZE];
    int s = 0; // Shift of the pattern over text

    // Preprocess the pattern to prepare the bad character table
    badCharHeuristic(pattern, m, badChar);

    printf("Matching positions: ");
    while (s <= (n - m)) {
        int j = m - 1;

        // Keep reducing index j of the pattern while characters match
        while (j >= 0 && pattern[j] == text[s + j]) {
            j--;
        }

        // If the pattern is present at current shift, print the position
        if (j < 0) {
            printf("%d ", s + 1); // +1 for 1-based indexing

            // Shift the pattern to align the next character in text
            s += (s + m < n) ? m - badChar[(int)text[s + m]] : 1;
        } else {
            // Shift the pattern to align the mismatched character
            s += (j - badChar[(int)text[s + j]] > 1) ? j - badChar[(int)text[s + j]] : 1;
        }
    }
    printf("\n");
}

void main() {
    char text[100], pattern[50];

    clrscr(); // Clear screen (specific to Turbo C)

    // Input the text
    printf("Enter the text: ");
    gets(text); // Turbo C compatible input for strings

    // Input the pattern
    printf("Enter the pattern: ");
    gets(pattern);

    // Call the Boyer-Moore search function
    boyerMooreSearch(text, pattern);

    getch(); // Wait for user input before exiting
}


            """;
        return response;
    }

    public String quickSort() {
        // Include your Quick Sort code hereString response = new String();
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>

// Function to swap two elements
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Partition function
int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // Pivot element
    int i = low - 1;       // Index of smaller element
    int j;

    for (j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

// Quick Sort function
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        // Partitioning index
        int pi = partition(arr, low, high);

        // Recursively sort elements before and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

void main() {
    int arr[50], n, i;

    clrscr(); // Clear screen (specific to Turbo C)

    // Input the number of elements
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    // Input the array elements
    printf("Enter the elements:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Perform Quick Sort
    quickSort(arr, 0, n - 1);

    // Print the sorted array
    printf("Sorted array:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }

    public String mergeSort() {
        // Include your Merge Sort code here
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>

// Function to merge two subarrays
void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1; // Size of the left subarray
    int n2 = right - mid;    // Size of the right subarray

    int L[50], R[50]; // Temporary arrays to hold subarrays
    int i, j, k;

    // Copy data to temporary arrays
    for (i = 0; i < n1; i++) {
        L[i] = arr[left + i];
    }
    for (j = 0; j < n2; j++) {
        R[j] = arr[mid + 1 + j];
    }

    // Merge the temporary arrays back into arr
    i = 0; // Initial index of left subarray
    j = 0; // Initial index of right subarray
    k = left; // Initial index of merged array

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements of L[], if any
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy remaining elements of R[], if any
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// Function to perform Merge Sort
void mergeSort(int arr[], int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2; // Calculate mid-point

        // Recursively sort the two halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }
}

void main() {
    int arr[50], n, i;

    clrscr(); // Clear screen (specific to Turbo C)

    // Input the number of elements
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    // Input the array elements
    printf("Enter the elements:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Perform Merge Sort
    mergeSort(arr, 0, n - 1);

    // Print the sorted array
    printf("Sorted array:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }

    public String dijkstraAlgorithm() {
        // Include your Dijkstra's algorithm code here
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>

#define INF 9999  // Representing infinity
#define MAX 10    // Maximum number of vertices

void dijkstra(int graph[MAX][MAX], int n, int start) {
    int cost[MAX][MAX], distance[MAX], visited[MAX], pred[MAX];
    int i, j, count, minDistance, nextNode;

    // Create cost matrix
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (graph[i][j] == 0) {
                cost[i][j] = INF;
            } else {
                cost[i][j] = graph[i][j];
            }
        }
    }

    // Initialize arrays
    for (i = 0; i < n; i++) {
        distance[i] = cost[start][i];
        pred[i] = start;
        visited[i] = 0;
    }

    distance[start] = 0;
    visited[start] = 1;
    count = 1;

    // Find shortest path
    while (count < n - 1) {
        minDistance = INF;

        // Choose the next node
        for (i = 0; i < n; i++) {
            if (distance[i] < minDistance && !visited[i]) {
                minDistance = distance[i];
                nextNode = i;
            }
        }

        // Mark the node as visited
        visited[nextNode] = 1;

        // Update the distance array
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                if (minDistance + cost[nextNode][i] < distance[i]) {
                    distance[i] = minDistance + cost[nextNode][i];
                    pred[i] = nextNode;
                }
            }
        }
        count++;
    }

    // Print the results
    for (i = 0; i < n; i++) {
        if (i != start) {
            printf("\nDistance to node %d = %d", i, distance[i]);
            printf("\nPath = %d", i);

            j = i;
            while (j != start) {
                j = pred[j];
                printf(" <- %d", j);
            }
        }
    }
}

void main() {
    int graph[MAX][MAX], n, start, i, j;

    clrscr(); // Clear screen (specific to Turbo C)

    // Input the number of vertices
    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    // Input the adjacency matrix
    printf("Enter the adjacency matrix:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            scanf("%d", &graph[i][j]);
        }
    }

    // Input the starting node
    printf("Enter the starting node: ");
    scanf("%d", &start);

    // Perform Dijkstra's algorithm
    dijkstra(graph, n, start);

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }

    public String fractionalKnapsack() {
        // Include your Fractional Knapsack code here
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>

// Function to find the maximum of two integers
int max(int a, int b) {
    return (a > b) ? a : b;
}

// Function to solve the Knapsack Problem using Dynamic Programming
void knapsack(int capacity, int weight[], int value[], int n) {
    int i, w;
    int dp[n + 1][capacity + 1];

    // Build the DP table
    for (i = 0; i <= n; i++) {
        for (w = 0; w <= capacity; w++) {
            if (i == 0 || w == 0) {
                dp[i][w] = 0; // Base case
            } else if (weight[i - 1] <= w) {
                dp[i][w] = max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    // Maximum value that can be carried
    printf("Maximum value in Knapsack = %d\n", dp[n][capacity]);

    // Traceback to find the items included in the knapsack
    printf("Items included:\n");
    w = capacity;
    for (i = n; i > 0 && dp[i][w] > 0; i--) {
        if (dp[i][w] != dp[i - 1][w]) {
            printf("Item %d (Weight: %d, Value: %d)\n", i, weight[i - 1], value[i - 1]);
            w -= weight[i - 1];
        }
    }
}

void main() {
    int n, capacity, i;

    clrscr(); // Clear screen (specific to Turbo C)

    // Input the number of items
    printf("Enter the number of items: ");
    scanf("%d", &n);

    int weight[n], value[n];

    // Input the weights and values of the items
    printf("Enter the weights and values of the items:\n");
    for (i = 0; i < n; i++) {
        printf("Item %d - Weight: ", i + 1);
        scanf("%d", &weight[i]);
        printf("Item %d - Value: ", i + 1);
        scanf("%d", &value[i]);
    }

    // Input the capacity of the knapsack
    printf("Enter the capacity of the knapsack: ");
    scanf("%d", &capacity);

    // Solve the knapsack problem
    knapsack(capacity, weight, value, n);

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }

    public String jobSequencingWithDeadlines() {
        // Include your Job Sequencing code here
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>

#define MAX 20

// Structure to represent a job
typedef struct {
    int id;      // Job ID
    int profit;  // Profit of the job
    int deadline; // Deadline of the job
} Job;

// Function to sort jobs in descending order of profit
void sortJobs(Job jobs[], int n) {
    int i, j;
    Job temp;

    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (jobs[j].profit < jobs[j + 1].profit) {
                temp = jobs[j];
                jobs[j] = jobs[j + 1];
                jobs[j + 1] = temp;
            }
        }
    }
}

// Function to find the maximum deadline
int findMaxDeadline(Job jobs[], int n) {
    int i, max = 0;
    for (i = 0; i < n; i++) {
        if (jobs[i].deadline > max) {
            max = jobs[i].deadline;
        }
    }
    return max;
}

// Function to perform Job Sequencing
void jobSequencing(Job jobs[], int n) {
    int maxDeadline = findMaxDeadline(jobs, n);
    int slot[MAX] = {0};  // Array to track used time slots
    int jobOrder[MAX];    // Array to store the job order
    int totalProfit = 0, i, j;

    // Sort jobs by profit in descending order
    sortJobs(jobs, n);

    // Iterate through each job
    for (i = 0; i < n; i++) {
        // Find a slot for this job (from its deadline to 0)
        for (j = jobs[i].deadline - 1; j >= 0; j--) {
            if (slot[j] == 0) { // Slot available
                slot[j] = 1;
                jobOrder[j] = jobs[i].id;
                totalProfit += jobs[i].profit;
                break;
            }
        }
    }

    // Print the job order
    printf("Job Sequence: ");
    for (i = 0; i < maxDeadline; i++) {
        if (slot[i] == 1) {
            printf("Job %d ", jobOrder[i]);
        }
    }
    printf("\nTotal Profit: %d\n", totalProfit);
}

void main() {
    int n, i;

    Job jobs[MAX];

    clrscr(); // Clear screen (specific to Turbo C)

    // Input the number of jobs
    printf("Enter the number of jobs: ");
    scanf("%d", &n);

    // Input job details
    printf("Enter the job details (ID, Profit, Deadline):\n");
    for (i = 0; i < n; i++) {
        printf("Job %d:\n", i + 1);
        printf("ID: ");
        scanf("%d", &jobs[i].id);
        printf("Profit: ");
        scanf("%d", &jobs[i].profit);
        printf("Deadline: ");
        scanf("%d", &jobs[i].deadline);
    }

    // Perform Job Sequencing
    jobSequencing(jobs, n);

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }

    public String allPairsShortestPath() {
        // Include your All Pairs Shortest Path code here
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>

#define MAX 10
#define INF 9999  // Representing infinity for unreachable paths

// Function to implement the Floyd-Warshall algorithm
void floydWarshall(int graph[MAX][MAX], int n) {
    int distance[MAX][MAX], i, j, k;

    // Initialize the distance matrix
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            distance[i][j] = graph[i][j];
        }
    }

    // Floyd-Warshall Algorithm
    for (k = 0; k < n; k++) {         // Intermediate nodes
        for (i = 0; i < n; i++) {     // Source node
            for (j = 0; j < n; j++) { // Destination node
                if (distance[i][k] + distance[k][j] < distance[i][j]) {
                    distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
    }

    // Print the resulting shortest distances
    printf("\nAll Pairs Shortest Path Matrix:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (distance[i][j] == INF) {
                printf("INF ");
            } else {
                printf("%4d ", distance[i][j]);
            }
        }
        printf("\n");
    }
}

void main() {
    int graph[MAX][MAX], n, i, j;

    clrscr(); // Clear the screen (specific to Turbo C)

    // Input the number of vertices
    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    // Input the adjacency matrix
    printf("Enter the adjacency matrix (enter %d for INF):\n", INF);
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            scanf("%d", &graph[i][j]);
        }
    }

    // Solve the all-pairs shortest path problem
    floydWarshall(graph, n);

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }
    public String queens(){
        String response = new String();
        response =
            """
#include <stdio.h>
#include <conio.h>

#define MAX 10

int board[MAX][MAX]; // Board to place queens
int n;               // Size of the board

// Function to check if a queen can be placed at board[row][col]
int isSafe(int row, int col) {
    int i, j;

    // Check this row on the left
    for (i = 0; i < col; i++) {
        if (board[row][i] == 1) {
            return 0;
        }
    }

    // Check upper diagonal on the left
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 1) {
            return 0;
        }
    }

    // Check lower diagonal on the left
    for (i = row, j = col; i < n && j >= 0; i++, j--) {
        if (board[i][j] == 1) {
            return 0;
        }
    }

    return 1; // Safe to place queen
}

// Function to solve the N-Queens problem using backtracking
int solveNQueens(int col) {
    int i;

    // Base case: If all queens are placed, return true
    if (col >= n) {
        return 1;
    }

    // Try placing a queen in all rows of this column
    for (i = 0; i < n; i++) {
        if (isSafe(i, col)) {
            // Place queen
            board[i][col] = 1;

            // Recur to place the rest of the queens
            if (solveNQueens(col + 1)) {
                return 1;
            }

            // Backtrack: Remove the queen
            board[i][col] = 0;
        }
    }

    return 0; // If no placement is possible, return false
}

// Function to print the board
void printBoard() {
    int i, j;

    printf("\nSolution:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (board[i][j] == 1) {
                printf(" Q ");
            } else {
                printf(" . ");
            }
        }
        printf("\n");
    }
}

void main() {
    int i, j;

    clrscr(); // Clear the screen (specific to Turbo C)

    // Input the size of the board
    printf("Enter the value of N (size of the board): ");
    scanf("%d", &n);

    // Initialize the board to 0
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            board[i][j] = 0;
        }
    }

    // Solve the N-Queens problem
    if (solveNQueens(0)) {
        printBoard();
    } else {
        printf("No solution exists for N = %d\n", n);
    }

    getch(); // Wait for user input before exiting
}

            """;
        return response;
    }
}
