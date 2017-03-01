package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteOrder;
import java.util.List;

/**
 *
 * User: fh
 * Date: 2017/2/28 下午5:51
 */
@Slf4j
public class UsStockHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in,
                          List<Object> out) throws Exception {

        int readBytes = in.readableBytes();
        in = in.order(ByteOrder.LITTLE_ENDIAN);
        if (readBytes < 3) {
            return;
        }

        //start read index
        int oldReaderIndex = in.readerIndex();
        int totalLength = in.readUnsignedShort();
        short msgType = in.readByte();

        readBytes = in.readableBytes();

        if (readBytes < totalLength) {
            in.readerIndex(oldReaderIndex);
            return;
        }

        int msgLength = totalLength - 3;
        ByteBuf msgBuf = in.readBytes(msgLength);
        String msg = new String(msgBuf.array());

        UsStockMsg usStockMsg = UsStockMsg.builder()
                .length(msgLength)
                .msg(msg)
                .msgType(msgType)
                .build();
        log.info("{}", usStockMsg);
        out.add(usStockMsg);
    }
}


