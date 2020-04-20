import android.app.Application;

import org.koin.core.KoinApplication;
import static com.example.fichapp.di.ModulesKt.appModule;
import static org.koin.core.context.GlobalContext.start;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KoinApplication koinApp = KoinApplication.create().printLogger().modules(appModule);
        start(koinApp);
    }
}
