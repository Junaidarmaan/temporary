package prog.adsa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/heap")
    public String heapSort() {
        return programService.heapSort();
    }

    @GetMapping("/bfs")
    public String breadthFirstSearch() {
        return programService.breadthFirstSearch();
    }

    @GetMapping("/dfs")
    public String depthFirstSearch() {
        return programService.depthFirstSearch();
    }

    @GetMapping("/brute")
    public String bruteForceStringMatching() {
        return programService.bruteForceStringMatching();
    }

    @GetMapping("/boyer")
    public String boyerMooreStringMatching() {
        return programService.boyerMooreStringMatching();
    }

    @GetMapping("/qs")
    public String quickSort() {
        return programService.quickSort();
    }

    @GetMapping("/ms")
    public String mergeSort() {
        return programService.mergeSort();
    }

    @GetMapping("/sssp")
    public String dijkstraAlgorithm() {
        return programService.dijkstraAlgorithm();
    }

    @GetMapping("/ks")
    public String fractionalKnapsack() {
        return programService.fractionalKnapsack();
    }

    @GetMapping("/jswd")
    public String jobSequencingWithDeadlines() {
        return programService.jobSequencingWithDeadlines();
    }

    @GetMapping("/apsp")
    public String allPairsShortestPath() {
        return programService.allPairsShortestPath();
    }
}
