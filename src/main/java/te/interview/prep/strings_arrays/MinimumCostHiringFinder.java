package te.interview.prep.strings_arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/minimum-cost-to-hire-k-workers/">Problem on leetcode</a>
 */
public class MinimumCostHiringFinder {

    /*
        Time:
            O(n log(n)) for sorting
            O(n log(k)) for n elements sorted through a max-heap of size k
            Since log(a) + log(b) === log(a*b) & b*log(a) === log(a^b)
            Our runtime complexity is O(log(n^n * k^n))
        Space:
            O(n)
     */
    public double ofSizeK(int[] quality, int[] wage, int k) {
        double minimumCost = Double.MAX_VALUE, totalQuality = 0.0d;

        PriorityQueue<Integer> qualityMaxHeap = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        for (JobApplicant applicant : asJobApplicantsSortedByRatio(wage, quality)) {
            totalQuality += applicant.quality;
            qualityMaxHeap.add(applicant.quality);

            // Remove the highest quality worker when we surpass k and adjust total
            if (qualityMaxHeap.size() > k) totalQuality -= qualityMaxHeap.poll();

            if (qualityMaxHeap.size() == k) {
                minimumCost = calcNewMinimumCost(minimumCost, totalQuality, applicant);
            }
        }

        return minimumCost;
    }

    /**
     * @return an array of job applicants sorted by their wage:quality ratio in ascending order.
     * This puts the workers that are most cost effective at the top.
     */
    private JobApplicant[] asJobApplicantsSortedByRatio(int[] wage, int[] quality) {
        JobApplicant[] ratios = new JobApplicant[quality.length];
        for (int i = 0; i < quality.length; i++) {
            ratios[i] = new JobApplicant(wage[i], quality[i]);
        }
        Arrays.sort(ratios);
        return ratios;
    }

    /**
     * Since the following are equivalent:
     *      wage / quality = ratio
     *      quality * ratio = wage
     *
     * Then we can conclude the following are also equivalent:
     *      total_wage / total_quality = total_ratio
     *      total_quality * total_ratio = total_wage
     *
     * Since we are processing workers in ascending order of their wage:quality ratio,
     * and since all workers are to be paid in the ratio of their quality compared
     * to the other workers in the paid group (rule 1), the current wage:quality
     * ratio we are on represents the total_ratio variable above. Therefore we have
     * what is required to calculate total_wage.
     *
     * @return the new minimum cost for our paid group
     */
    private double calcNewMinimumCost(double existingMin, double totalQuality, JobApplicant applicant) {
        return Double.min(existingMin, totalQuality * applicant.wageToQualityRatio);
    }

    private static class JobApplicant implements Comparable<JobApplicant> {
        double wageToQualityRatio;
        int quality;

        JobApplicant(int wage, int quality) {
            this.quality = quality;
            this.wageToQualityRatio = (double) wage / quality;
        }

        @Override
        public int compareTo(JobApplicant otherApplicant) {
            return Double.compare(wageToQualityRatio, otherApplicant.wageToQualityRatio);
        }
    }
}
