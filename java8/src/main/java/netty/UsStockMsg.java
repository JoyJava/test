package netty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
class UsStockMsg {
    int length;
    String msg;
    short msgType;


}