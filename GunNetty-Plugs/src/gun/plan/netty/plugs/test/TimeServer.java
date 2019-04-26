package gun.plan.netty.plugs.test;


import gun.plan.netty.plugs.handle.GunHttpMappingHandle;
import gun.plan.netty.plugs.protocols.BaseGunHttp2Response;
import top.gunplan.netty.anno.GunHttpBaseContent;
import top.gunplan.netty.anno.GunHttpmapping;
import top.gunplan.netty.protocol.GunNetInputInterface;
import top.gunplan.netty.protocol.GunNetOutputInterface;
import top.gunplan.netty.protocol.resputil.GunMappingJsonResp;

@GunHttpmapping(mappingRule = "/time")
@GunHttpBaseContent
public class TimeServer implements GunHttpMappingHandle<GunNetOutputInterface> {
    public TimeServer() {
    }


    @Override
    public GunNetOutputInterface doOutput(GunNetInputInterface protocl) {
        BaseGunHttp2Response response = new BaseGunHttp2Response() {
            @Override
            public String toResponse() {
                GunMappingJsonResp resp = new GunMappingJsonResp();
                resp.put("time", String.valueOf(System.currentTimeMillis()));
                return resp.toTransfer();
            }
        };
        response.setIswrite(true);
        return response;
    }
}
