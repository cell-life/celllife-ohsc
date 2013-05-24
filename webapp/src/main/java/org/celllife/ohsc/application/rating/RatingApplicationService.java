package org.celllife.ohsc.application.rating;

import java.util.Date;

import org.celllife.ohsc.domain.datamart.ClinicIndividualRatingPageDTO;
import org.celllife.ohsc.domain.rating.Rating;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h14
 */
public interface RatingApplicationService {

    void save(Rating rating);
    
    /**
     * Retrieves one page of individual ratings for a clinic
     *
     * @param clinicCode String unique clinic code
     * @param startDate Date beginning date of the date range
     * @param endDate Date last date of the date range
     * @param iDisplayStart Integer element number for the start of the page
     * @param iDisplayLength Integer size of the page
     * @param sSearch String search text
     * @param iSortingCols Integer number of columns sorted
     * @param iSortCol_0 Integer first sort column index
     * @param iSortCol_1
     * @param iSortCol_2
     * @param iSortCol_3
     * @param iSortCol_4
     * @param iSortCol_5
     * @param iSortCol_6
     * @param iSortCol_7
     * @param sSortDir_0 String "asc" or "desc" depending on the sort direction
     * @param sSortDir_1
     * @param sSortDir_2
     * @param sSortDir_3
     * @param sSortDir_4
     * @param sSortDir_5
     * @param sSortDir_6
     * @param sSortDir_7
     * @param sEcho String dataTables specific data which needs to be sent back with the request
     * @return
     */
    ClinicIndividualRatingPageDTO findIndividualRatingsByClinic(
    		String clinicCode, Date startDate, Date endDate,
    		Integer iDisplayStart, Integer iDisplayLength, String sSearch,	Integer iSortingCols,
			Integer iSortCol_0,	Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,	Integer iSortCol_7,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3,	String sSortDir_4, String sSortDir_5, String sSortDir_6, String sSortDir_7,
			String sEcho);

}
