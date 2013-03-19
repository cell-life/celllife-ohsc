package org.celllife.ohsc.application.average;

import junit.framework.Assert;
import org.junit.Test;

import static org.celllife.ohsc.application.average.ClinicAverageApplicationServiceImpl.calculateNewAverage;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 19h04
 */
public class ClinicAverageServiceImplTest {

    @Test
    public void testCalculateNewDomainAverage() throws Exception {

        Double average = calculateNewAverage(0D, 0, 1);
        average = calculateNewAverage(average, 1, 2);
        average = calculateNewAverage(average, 2, 3);
        average = calculateNewAverage(average, 3, 4);
        average = calculateNewAverage(average, 4, 5);
        average = calculateNewAverage(average, 5, 6);

        // 31  = 1 + 2 + 3 + 4 + 5 + 6
        // 3.5 = 31 / 6
        Assert.assertEquals(3.5D, average);
    }
}
