package com.znsio.sample.e2e.screen.bookMyShow;

import com.znsio.sample.e2e.screen.web.bookMyShow.CinemaHallScreenWeb;
import com.znsio.teswiz.entities.Platform;
import com.znsio.teswiz.runner.Driver;
import com.znsio.teswiz.runner.Drivers;
import com.znsio.teswiz.runner.Runner;
import com.znsio.teswiz.runner.Visual;
import org.apache.commons.lang.NotImplementedException;

import java.util.logging.Logger;

public abstract class CinemaHallScreen {
    private static final String SCREEN_NAME = CinemaHallScreen.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);

    public static CinemaHallScreen get() {
        Driver driver = Drivers.getDriverForCurrentUser(Thread.currentThread().getId());
        Platform platform = Runner.fetchPlatform(Thread.currentThread()
                .getId());
        LOGGER.info(SCREEN_NAME + ": Driver type: " + driver.getType() + ": Platform: " + platform);
        Visual visually = Drivers.getVisualDriverForCurrentUser(Thread.currentThread().getId());

        switch (platform) {
            case web:
                return new CinemaHallScreenWeb(driver, visually);
        }
        throw new NotImplementedException(SCREEN_NAME + " is not implemented in " + Runner.getPlatform());

    }

    public abstract CinemaHallScreen selectTheThirdHall();

    public abstract CinemaHallScreen selectSecondSlot(String cinemaHallTitle);

    public abstract CinemaHallScreen selectNumberOfPeople(int numberOfSeats);
}