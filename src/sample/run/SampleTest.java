package sample.run;

import java.util.HashMap;
import java.util.Map;

import core.comm.RepositoryUtils;
import core.model.Datum;
import core.service.RepositoryService;
import sample.comm.SampleConstants;

public class SampleTest {
	private static RepositoryService repositoryService = RepositoryService.getInstance();
	
	public static void main(String[] args) {
		String uri1 = "http://sam.sample.sam/abc/bbc/dd?a=2&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56";
		String uri2 = "http://sam1.sample.sam/abc/bbc/dd?a=24444&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56";
		String param1 = "http://sam2.sample.sam/abc/bbc/dd?a=2&b=255&c=456&b=342&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56&b=2&c=56";
		
		
		// data
		Map<String, Datum> landingData = repositoryService.getData(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.LANDING_URI);
		Map<String, Datum> popupData = repositoryService.getData(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.POPUP_URI);
		Map<String, Datum> callData = repositoryService.getData(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.CALL_URI);
		
		
		Map<String, Integer> landingKeys = new HashMap<>();
		Map<String, Integer> popupKeys = new HashMap<>();
		Map<String, Integer> callKeys = new HashMap<>();
		RepositoryUtils.addURI(landingData, landingKeys, uri1);
		RepositoryUtils.addURI(popupData, popupKeys, uri2);
		RepositoryUtils.addParameterString(callData, callKeys, param1);
		
		
		System.out.println(landingKeys);
		System.out.println(popupKeys);
		System.out.println(callKeys);
		System.out.println(repositoryService.getRepository(SampleConstants.REPOSITORY_KEY.REP1));
		
		
		System.out.println("--------------------------------------------------");
		
		repositoryService.saveUri(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.LANDING_URI, uri1);
		repositoryService.saveUri(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.POPUP_URI, uri2);
		repositoryService.saveParameterString(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.CALL_URI, param1);
		
		
		System.out.println(landingKeys);
		System.out.println(popupKeys);
		System.out.println(callKeys);
		System.out.println(repositoryService.getRepository(SampleConstants.REPOSITORY_KEY.REP1));
		
		System.out.println("--------------------------------------------------");
		
		
		repositoryService.saveUri(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.CALL_URI, param1);
		
		System.out.println(landingKeys);
		System.out.println(popupKeys);
		System.out.println(callKeys);
		System.out.println(repositoryService.getRepository(SampleConstants.REPOSITORY_KEY.REP1));
		
		System.out.println("--------------------------------------------------");
		
		String value1 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaaaaaaaaaaaAAAAAAAAAAAAAAA";
		String value2 = "BBBBbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		String value3 = "CCCCCCCCCCCCCCCCCCccccccccccccccccccccccccccccccc";
		
		
		Map<String, Map<String, Datum>> reps = repositoryService.getRepository(SampleConstants.REPOSITORY_KEY.REP1);
		Map<String, Datum> commonData = new HashMap<>();
		reps.put(SampleConstants.DATA_KEY.COMMON, commonData);
		
		Map<String, Datum> commonData2 = repositoryService.getData(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.COMMON);
		System.out.println(commonData == commonData2);
		
		
		System.out.println("--------------------------------------------------");
		
		
		Map<String, Integer> commonKeys = repositoryService.saveValue(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.COMMON, null, "A", value1);
		repositoryService.saveValue(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.COMMON, commonKeys, "B", value2);
		repositoryService.saveValue(SampleConstants.REPOSITORY_KEY.REP1, SampleConstants.DATA_KEY.COMMON, commonKeys, "C", value3);
		
		System.out.println(commonKeys);
		System.out.println(repositoryService.getRepository(SampleConstants.REPOSITORY_KEY.REP1));
	}
	
}
