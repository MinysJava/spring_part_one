package chat.server.auth;

import chat.server.User;

public interface AuthService {

    boolean authUser(User user);
}
