package online.ronakon.stockmanagement.monitor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public interface MonitorFactory {

	Monitor start(String name);
}
