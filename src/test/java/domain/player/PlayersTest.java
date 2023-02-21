package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @Test
    @DisplayName("중복된 이름을 가진 참가자가 없을 경우 Players 객체가 생성된다.")
    void createPlayers_Success() {
        List<String> playersName = List.of("gray", "encho", "pobi");
        assertThatNoException().isThrownBy(() -> new Players(playersName));
    }

    @Test
    @DisplayName("중복된 이름을 가진 참가자가 있을 경우 예외가 발생한다.")
    void createPlayers_Fail() {
        List<String> playersName = List.of("gray", "encho", "gray");
        assertThatThrownBy(() -> new Players(playersName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 참여자의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("참가자 수가 2명 이상 50명 이하이면 Players 객체가 생성된다.")
    void creteNumberOfPlayers_Success() {
        List<String> playersName = List.of("gray", "encho", "pobi");
        assertThatNoException().isThrownBy(() -> new Players(playersName));
    }

    @Test
    @DisplayName("참가자 수가 2명미만 이거나 50명 초과이면 예외가 발생한다.")
    void createNumberOfPlayers_Fail() {
        List<String> playersName = List.of("gray");
        assertThatThrownBy(() -> new Players(playersName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.");
    }
}
