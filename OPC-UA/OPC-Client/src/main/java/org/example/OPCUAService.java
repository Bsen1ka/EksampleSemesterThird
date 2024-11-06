package org.example;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class OPCUAService {

    private final OpcuaDataRepository opcuaDataRepository;

    @Autowired
    public OPCUAService(OpcuaDataRepository opcuaDataRepository) {
        this.opcuaDataRepository = opcuaDataRepository;
    }

    public void readAndSaveNodeValue() {
        opcuaDataRepository.count();
        String nodeIdStr = "::Program:Cube.Command.MachSpeed";
        try {
            OpcUaClient client = OpcUaClient.create("opc.tcp://127.0.0.1:4840");
            client.connect().get();

            NodeId nodeId = new NodeId(6, nodeIdStr);
            CompletableFuture<DataValue> future = client.readValue(0, TimestampsToReturn.Both, nodeId);
            DataValue dataValue = future.get();

            Variant variant = dataValue.getValue();
            System.out.println(variant + "before");
            if (variant.getValue() != null) {
                System.out.println(variant + "after");
                OPCUAData opcUaData = new OPCUAData();

                opcUaData.setNode_id(nodeIdStr);
                opcUaData.setValue(variant.getValue().toString());

                opcuaDataRepository.save(opcUaData);
                System.out.println("Saved NodeId: " + nodeIdStr + " with value: " + variant.getValue());
            }

            client.disconnect().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
