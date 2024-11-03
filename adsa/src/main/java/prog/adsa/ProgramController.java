package prog.adsa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/heapSort")
    public String heapSort() {
        return programService.heapSort();
    }

    @GetMapping("/breadthFirstSearch")
    public String breadthFirstSearch() {
        return programService.breadthFirstSearch();
    }

    @GetMapping("/depthFirstSearch")
    public String depthFirstSearch() {
        return programService.depthFirstSearch();
    }

    @GetMapping("/bruteForceStringMatching")
    public String bruteForceStringMatching() {
        return programService.bruteForceStringMatching();
    }

    @GetMapping("/boyerMooreStringMatching")
    public String boyerMooreStringMatching() {
        return programService.boyerMooreStringMatching();
    }

    @GetMapping("/quickSort")
    public String quickSort() {
        return programService.quickSort();
    }

    @GetMapping("/mergeSort")
    public String mergeSort() {
        return programService.mergeSort();
    }

    @GetMapping("/dijkstraAlgorithm")
    public String dijkstraAlgorithm() {
        return programService.dijkstraAlgorithm();
    }

    @GetMapping("/fractionalKnapsack")
    public String fractionalKnapsack() {
        return programService.fractionalKnapsack();
    }

    @GetMapping("/jobSequencingWithDeadlines")
    public String jobSequencingWithDeadlines() {
        return programService.jobSequencingWithDeadlines();
    }

    @GetMapping("/allPairsShortestPath")
    public String allPairsShortestPath() {
        return programService.allPairsShortestPath();
    }
}
