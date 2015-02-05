package org.xiaotian.minicached.study;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
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
//		    final ByteBuf b = ctx.alloc().buffer(5) ;
//			 b.writeBytes("hello".getBytes()) ;
//			 ctx.write(b) ;
//			 ctx.flush() ;
	}
	
	 public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
//		 System.out.println("sss" + ctx.channel().remoteAddress().toString());
//		 
//		 final ByteBuf b = ctx.alloc().buffer(5) ;
//		 b.writeBytes("hello".getBytes()) ;
//		 ctx.write(b) ;
//		 ctx.flush() ;
	 }
	 
	 public void channelActive(final ChannelHandlerContext ctx ) throws Exception{
//		 final ByteBuf time = ctx.alloc().buffer(4); // (2)
//	        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//
//	        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//	        f.addListener(new ChannelFutureListener() {
//	            public void operationComplete(ChannelFuture future) {
//	                assert f == future;
//	                ctx.close();
//	            }
//	        }); // 
		 //Only execute once.
		 System.out.print("a");
		 final ByteBuf b = ctx.alloc().buffer(5) ;
		 b.writeBytes("hello".getBytes()) ;
		 ctx.write(b) ;
		 ctx.flush() ;
//		 ReferenceCountUtil.release(b) ;
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
