#!/bin/bash

#example json documents to test API and correctly interaction with MongoDB.

#cpu
curl -H "Content-Type:application/json" -d '{"producent":"AMD", "model":"Ryzen 5 1600", "description":"AMD Ryzen 5 1600 wprowadza na rynek nową jakość. Wszystko za sprawą usprawnienia procesu technologicznego 14 nm, przyspieszenia pamięci podręcznej (zwłaszcza na poziomie L2 i L3) oraz zwiększenia parametru IPC, odpowiedzialnego za realizację operacji w ramach jednego cyklu zegara. Dzięki temu praca Twojego komputera stanie się znacznie sprawniejsza niż do tej pory.", "compatibleIndex":7.0, "componentType":"cpu", "cpuParameters":{"cores":6, "series":"Ryzen 5", "socket":"AM4", "threads":12, "bitArchitecture":"64bit", "cache":16, "frequency":3.2}}' -X POST http://localhost:8080/components

#cpu
curl -H "Content-Type:application/json" -d '{"producent":"Intel", "model":"Celeron G3900", "description":"Dwa wydajne rdzenie fizyczne! Dedykowany do zestawów biurowych!", "compatibleIndex":4.0, "componentType":"cpu", "cpuParameters":{"cores":2, "series":"Celeron", "socket":"1151", "threads":2, "bitArchitecture":"64bit", "cache":2, "frequency":2.8}}' -X POST http://localhost:8080/components

#cpu
curl -H "Content-Type:application/json" -d '{"producent":"Intel", "model":"i3 (coffee lake)", "description":"4 bardzo wydajne rdzenie fizyczne! Najlepszy wybór w tej cenie!", "compatibleIndex":4.8, "componentType":"cpu", "cpuParameters":{"cores":4, "series":"intel core 8th gen - coffee lake", "socket":"1151(coffee lake)", "threads":4, "bitArchitecture":"64bit", "cache":6, "frequency":3.6}}' -X POST http://localhost:8080/components

#motherboard
curl -H "Content-Type:application/json" -d '{"producent":"MSI", "model":"H110M PRO-VD (LGA 1151 ATX)", "description":"Najwyższa jakość komponentów i niezawodny chipset produkcji Intel to główne cechy płyt głównych MSI. Dzięki temu będziesz mógł zaistalować w swoim komputerze wydajne podzespoły, które sprawią, że ulubione gry oraz programy będą działały płynnie. Gniazdo procesora obsługiwane przez płytę główną to socket - 1151.", "compatibleIndex":4.0, "componentType":"motherboard", "motherboardParameters":{"type":"Micro ATX", "chipset":"H110", "socket":"1151", "ramSockets":2, "bios":"click UEFI", "memoryType":"DDR4", "memoryFrequency":2133, "procesorAvailables":["Intel Celeron", "Intel Core i3", "Intel Core i5", "Intel Core i7", "Intel Pentium"], "otherSockets":["PCI Express x1 (2 szt.)", "PCI Express x16 (1 szt.)", "SATA III x4", "1x czujnik otwarcia obudowy"]}}' -X POST http://localhost:8080/components

#motherboard
curl -H "Content-Type:application/json" -d '{"producent":"MSI", "model":"A320M Gaming Pro", "description":"Stwórz swoją własną kolorystykę i dostosuj efekty świetlne z technologią RGB Mystic Light. Możesz wybrać dowolną barwę z dostępnej palety kolorów i spersonalizować wygląd komputera korzystając w tym celu ze smartfona lub aplikacji MSI Gaming App. Znudziły cię te same kolory podświetlenia? Dosłownie w sekundę możesz je całkowicie zmienić i przebudować wygląd swojego peceta! Możesz przechytrzyć i wyprzedzić swoich przeciwników w grze korzystając z zestawu unikatowych gamingowych narzędzi MSI. ", "compatibleIndex":7.0 , "componentType":"motherboard", "motherboardParameters":{"type":"Micro ATX", "chipset":"AMD A320", "socket":"AM4", "ramSockets":2 , "bios":"Click BIOS 5", "memoryType":"DDR4", "memoryFrequency":2133, "procesorAvailables":["AMD seria A" , "AMD Ryzen"], "otherSockets":["2x PCI Express 2.0 x1" , "1x PCI Express 3.0 x16", "4x SATA III", "1x M.2 slot", "ATX12V 8P", "Wł./wył. Clear CMOS", "TPM", "2x USB 2.0 (umożliwiają wyprowadzenie 4 portów USB2.0)", "Serial", "Czujnik otwarcia obudowy", "1x Audio przedniego panelu", "1x Parallel", "1x 24-pin ATX 12V", "1x USB 3.1 gen 1 (obsługa 2 portów)", "1x 4-pin CPU FAN", "1x RGB LED", "2x FAN", "2x system panel"]}}' -X POST http://localhost:8080/components

#ram
curl -H "Content-Type:application/json" -d '{"producent":"Ballistix", "model":"Sport LT", "description":"Zaprojektowane z myślą o entuzjastach, graczach i wszystkich tych, którzy oczekują od swojego komputera więcej niż tylko działania. Zapewnij swojemu procesorowi niezbędne zasoby i spraw, by komputer był szybszy.", "compatibleIndex":2.4, "componentType":"ram", "ramParameters":{"memoryType":"DDR4", "cooler":"Radiator", "modules":2, "capacityGb":8, "frequency":2400, "socketType":"UDIMM"}}' -X POST http://localhost:8080/components

#ram
curl -H "Content-Type:application/json" -d '{"producent":"Kingston", "model":"HyperX FURY", "description":"Automatycznie rozpoznaje platformę, w której jest zainstalowana i przetaktowuje się do najwyższej dostępnej częstotliwości. Asymetryczny radiator zapewnia udoskonalone rozpraszanie ciepła.", "compatibleIndex":2.1, "componentType":"ram", "ramParameters":{"memoryType":"DDR4", "cooler":"Radiator", "modules":2, "capacityGb":8, "frequency":2133, "socketType":"UDIMM"}}' -X POST http://localhost:8080/components

#disk
curl -H "Content-Type:application/json" -d '{"producent":"Kingston", "model":"SSDNow UV400", "description":"Wydajny i niedrogi dysk SSD bazujący na kościach TLC, który zapewni wysokie transfery rzędu 550/500 MB/s !", "compatibleIndex":9.1, "componentType":"disk", "diskParameters":{"type":"SSD", "format":"2.5", "capacity":240, "readSpeed":550, "writeSpeed":490}}' -X POST http://localhost:8080/components

#disk
curl -H "Content-Type:application/json" -d '{"producent":"Hitachi", "model":"Travelstar 7K1000", "description":"32 MB pamięci podręcznej oraz prędkość obrotowa 7200 obr/min. zapewniają wysoką wydajność urządzenia a technologia TrueTrack zapobiega jej spadkom.", "compatibleIndex":9.0, "componentType":"disk", "diskParameters":{"type":"HDD", "format":"HDD standard", "capacity":1024, "readSpeed":12, "writeSpeed":4.2}}' -X POST http://localhost:8080/components

#graphic card
curl -H "Content-Type:application/json" -d '{"producent":"Gigabyte", "model":"GeForce GTX 1050 Ti OC", "description":"Karty graficzne z serii GeForce GTX 10 oparte są na architekturze Pascal, zapewniając nawet trzykrotnie wyższą wydajność w porównaniu do kart graficznych poprzedniej generacji, a także nowe, innowacyjne technologie gamingowe.", "compatibleIndex":12 , "componentType":"gpu", "graphicsCardParameters":{"memory":4, "memoryType":"DDR5", "mainConnectorType":"PCI Express x16", "length":19.1, "clockFrequency":1341, "resolution":"7680x4320", "cooler":"2x fan + radiator", "standards":["DirectX 12", "OpenGL 4.5"], "connectors":["DVI-D", "HDMI", "DisplayPort"]}}' -X POST http://localhost:8080/components

#supply
curl -H "Content-Type:application/json" -d '{"producent":"be quiet!", "model":"Straight Power 11", "description":"Produkt z najnowszej, a zarazem najcichszej serii hight-endowych zasilaczy be quiet! Straight Power 11 550W to kompletnie przeprojektowane wnętrze, brak przewodów po stronie wtórnej oraz nowoczesna topologia oparta na wysokiej jakości komponentach.", "compatibleIndex":0.550, "componentType":"supply", "powerSupplyParameters":{"standard":"ATX", "power":550, "pfc":"active", "cooler":"fan", "modularCable":true, "connectors":["ATX 24-pin (20+4)", "PCI-E 8-pin (6+2) x2", "CPU 4+4 (8) pin", "SATA x9", "Molex x3"]}}' -X POST http://localhost:8080/components

#case
curl -H "Content-Type:application/json" -d '{"producent":"Sharkoon", "model":"TG5", "description":"Model ten posiada jedno wzmocnione szkło hartowane na panelu bocznym oraz drugie także wzmocnione szkło hartowane na samym przodzie, obydwa o grubości 4mm. W środku zmieścimy płyty główne od ATX po mini-ITX oraz karty graficzne do 400mm.", "compatibleIndex":40, "componentType":"computercase", "computerCaseParameters":{"type":"Midi Tower", "height":46.5, "width":22, "weight":8.5, "compatibilityMotherboards":["Micro ATX (uATX)", "Mini ITX", "ATX"], "connectors":["USB 2.0 x2", "USB 3.0 x2", "microphone", "phones"]}}' -X POST http://localhost:8080/components


