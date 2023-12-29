package com.joboffer.Agent;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgentServiceImp implements AgentService{
    private final AgentRepository agentRepository;
    private final ModelMapper modelMapper;
    @Override
    public AgentRequest createAgent(AgentRequest agentRequest) {
        Agent agent = modelMapper.map(agentRequest, Agent.class);
        Agent savedAgent = agentRepository.save(agent);
        return modelMapper.map(savedAgent, AgentRequest.class);
    }

    @Override
    public AgentRequest updateAgent(AgentRequest agentRequest) {
        return null;
    }

    @Override
    public AgentResponse getAgentById(Long id) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        return optionalAgent.map(agent -> modelMapper.map(agent, AgentResponse.class)).orElseThrow();
    }

    @Override
    public List<AgentResponse> getAllAgent() {
        List<Agent> responseList = agentRepository.findAll();
        return responseList.stream().map(agent -> modelMapper.map(agent, AgentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
