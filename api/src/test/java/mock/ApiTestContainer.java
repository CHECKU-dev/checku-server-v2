package mock;

import com.checku.api.bookmark.BookmarkApi;
import com.checku.api.user.UserApi;
import com.checku.core.mock.CoreTestContainer;

public class ApiTestContainer {

    public final CoreTestContainer coreTestContainer;
    public final UserApi userApi;
    public final BookmarkApi bookmarkApi;

    public ApiTestContainer() {
        coreTestContainer = new CoreTestContainer();
        this.userApi = new UserApi(coreTestContainer.userCommandService, coreTestContainer.userQueryService);
        this.bookmarkApi = new BookmarkApi(coreTestContainer.bookmarkCommandService);
    }
}
