package com.joboffer.Agent;

import java.util.List;

public interface AgentService {
    AgentRequest createAgent(AgentRequest agentRequest);
    AgentRequest updateAgent(AgentRequest agentRequest);
    AgentResponse getAgentById(Long id);
    List<AgentResponse> getAllAgent();
    void deleteAgent(Long id);

}
