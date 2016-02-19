package com.fest.persistence;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.fest.formatters.FestivityDateFormatter;

public class SingletonMemoryPersistence implements FestivityParser{

    private static SingletonMemoryPersistence instance = null;
    private static ArrayList<Festivity> Festivities = new ArrayList<Festivity>();
    private static AtomicLong counter = new AtomicLong();
    
    private SingletonMemoryPersistence() { }
    
    /**
     * Classic implementation of a Singleton Pattern to obtain a unique memory managed ArrayList
     * @return The single instance of the class.
     */
    public static synchronized SingletonMemoryPersistence getInstance() {
        if (instance == null) {
            instance = new SingletonMemoryPersistence();
            XMLFestLoader loader = new DirectFestLoader();
            Path route = Paths.get(System.getProperty("user.home"),"festivities.xml");
            Festivities.addAll(loader.extractTrasnformLoad(route.toString()));
            if (Festivities.size() > 0) {
				counter = new AtomicLong(Festivities.get(Festivities.size()-1).getId());
			}
            
        }

        return instance;
    }

	@Override
	public String getAll() {
		StringBuilder result = new StringBuilder();
		for (Festivity festivity : Festivities) {
			result.append(festivity.getPipedString());
			result.append('&');
		}
		if (result.length() > 0) {
			result.deleteCharAt(result.lastIndexOf("&"));
		}
		return result.toString();
	}

	@Override
	public String getBy(String festName, String festStartDate, String festEndDate, String festPlace) {
		StringBuilder result = new StringBuilder();
		Date startDate = FestivityDateFormatter.formatStringWeb(festStartDate);
		Date endDate = FestivityDateFormatter.formatStringWeb(festEndDate);
		for (Festivity festivity : Festivities) {
			if (festivity.getFestName().equals(festName)
					||festivity.getFestPlace().equals(festPlace)
					||festivity.getFestStartDate().equals(startDate)
					||festivity.getFestEndDate().equals(endDate)) {
				result.append(festivity.getPipedString());
				result.append('&');
			}
		}
		if (result.length() > 0) {
			result.deleteCharAt(result.lastIndexOf("&"));
		}
		return result.toString();
	}

	@Override
	public long createFestivity(String festName, String festStartDate, String festEndDate, String festPlace) {
		Date startDate = FestivityDateFormatter.formatStringWeb(festStartDate);
		Date endDate = FestivityDateFormatter.formatStringWeb(festEndDate);
		if (startDate != null
				&& endDate != null
				&& startDate.before(endDate)
				&& festName != null && !festName.isEmpty()
				&& festPlace != null && !festPlace.isEmpty()) {
			
			long id = counter.incrementAndGet();
			Festivities.add(new Festivity(id, festName, startDate, endDate, festPlace));
			return id;
		}
		return 0;
	}

	@Override
	public boolean updateFestivity(long id, String festName, String festStartDate, String festEndDate, String festPlace) {
		int index = -1;
		for (int i = 0; i < Festivities.size(); i++) {
			if (Festivities.get(i).getId() == id) {
				index = i;
			}
		}
		// If the id exists in the array, we will eliminate an recreate the Festivity.
		if (index != -1) {
			Festivities.remove(index);
			return createFestivity(festName, festStartDate, festEndDate, festPlace) != 0;
		}
		return false;
	}
	
}
