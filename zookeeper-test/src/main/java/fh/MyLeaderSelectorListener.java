package fh;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.CancelLeadershipException;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;

/**
 * User: fh
 * Date: 16/10/31 下午5:17
 */
public interface MyLeaderSelectorListener extends LeaderSelectorListener {

    @Override
    default void stateChanged(CuratorFramework client, ConnectionState newState) {
        if ((newState == ConnectionState.SUSPENDED) || (newState == ConnectionState.LOST)) {
            throw new CancelLeadershipException();
        }
    }

}
