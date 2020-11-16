package unip.pim4s.pim4s.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unip.pim4s.pim4s.Models.Client;
import unip.pim4s.pim4s.Models.Investment;
import unip.pim4s.pim4s.Repositories.ClientRepository;
import unip.pim4s.pim4s.Repositories.InvestimentRepository;
import unip.pim4s.pim4s.Requests.InvestimentRequest;

@Service
public class InvestmentService {
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvestimentRepository investimentRepository;

	public Investment create(InvestimentRequest request) {
		Investment investment = new Investment(Double.valueOf(request.getValue()), request.getTime(),
				request.getDescription());

		investment.setReturnSpectValue(Double.valueOf(request.getReturnSpectValue()));
		investment.setReturnedValue(0.0);
//
		Client client = clientRepository.findById(Integer.valueOf(request.getClientId())).get();
//
		investment.setClient(client);
//
		investimentRepository.save(investment);

		return investment;

	}
}
