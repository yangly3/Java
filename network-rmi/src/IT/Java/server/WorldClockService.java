package IT.Java.server;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import IT.Java.shared.WorldClock;

public class WorldClockService implements WorldClock {

	@Override
	public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
		return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
	}
}
