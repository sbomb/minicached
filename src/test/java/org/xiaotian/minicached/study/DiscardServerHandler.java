package org.xiaotian.minicached.study;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
	
	public void channelRead(ChannelHandlerContext ctx , Object msg){
		 ByteBuf in = (ByteBuf) msg;
//		 System.out.println(ctx);
		    try {
		        while (in.isReadable()) { // (1)
		            System.out.print((char) in.readByte());
		            System.out.flush();
		        }
		       
		    } finally {
		        ReferenceCountUtil.release(msg); // (2)
		    }
		    
//		    ctx.write("ÄãºÃ") ;
//		    ctx.flush() ;
//		 ctx.write(msg) ; 
//	     ctx.flush() ;
	}
	
	 public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
		 System.out.println("sss" + ctx.channel().remoteAddress().toString());
		 
		 ctx.write("abcdef") ;
		 ctx.flush() ;
	 }
	
	public void exceptionCaught(ChannelHandlerContext ctx , Throwable cause){
		 // Close the connection when an exception is raised.
		
		cause.printStackTrace(); 
		ctx.close() ; 
	}
	
//	public void channelRead(ChannelHandlerContext ctx, Object msg) {
//	    try {
//	        // Do something with msg
//	    } finally {
//	        ReferenceCountUtil.release(msg);
//	    }
//	}
}
