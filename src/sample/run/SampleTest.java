package sample.run;

import java.util.Map;

import core.model.Datum;
import core.service.RepositoryService;
import sample.comm.SampleConstants;

public class SampleTest {
	private static RepositoryService repositoryService = RepositoryService.getInstance();
	
	public static void main(String[] args) {
		// data
		Map<String, Datum> randingData = repositoryService.getData(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.LANDING_URI);
		Map<String, Datum> popupData = repositoryService.getData(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.POPUP_URI);
		Map<String, Datum> callData = repositoryService.getData(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.CALL_URI);
		
		
		
		
		
	}
	
}
