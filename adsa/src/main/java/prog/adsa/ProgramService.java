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
        return "Brute Force String Matching Code Output";
    }

    public String boyerMooreStringMatching() {
        // Include your Boyer-Moore String Matching code here
        return "Boyer-Moore String Matching Code Output";
    }

    public String quickSort() {
        // Include your Quick Sort code here
        return "Quick Sort Code Output";
    }

    public String mergeSort() {
        // Include your Merge Sort code here
        return "Merge Sort Code Output";
    }

    public String dijkstraAlgorithm() {
        // Include your Dijkstra's algorithm code here
        return "Dijkstra's Algorithm Code Output";
    }

    public String fractionalKnapsack() {
        // Include your Fractional Knapsack code here
        return "Fractional Knapsack Code Output";
    }

    public String jobSequencingWithDeadlines() {
        // Include your Job Sequencing code here
        return "Job Sequencing Code Output";
    }

    public String allPairsShortestPath() {
        // Include your All Pairs Shortest Path code here
        return "All Pairs Shortest Path Code Output";
    }
}
