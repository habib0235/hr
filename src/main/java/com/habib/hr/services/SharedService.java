package com.habib.hr.services;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class SharedService {

	public DozerBeanMapper getDozerInstance() {
		synchronized (this) {
			return new DozerBeanMapper();
		}
	}

	public <S, U> U MapSingleObject(S s, Class<U> u) {
		DozerBeanMapper mapper = getDozerInstance();
		return mapper.map(s, u);
	}

	public <S, U> List<U> MapListOfObject(List<S> s, Class<U> u) {
		DozerBeanMapper mapper = getDozerInstance();
		return s.stream().map(e -> mapper.map(e, u)).collect(Collectors.toList());
	}

}
